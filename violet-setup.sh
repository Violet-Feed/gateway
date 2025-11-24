#!/bin/bash

set -e

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 日志函数
log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

log_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# 检查 Docker 和 Docker Compose
check_docker() {
    log_info "检查 Docker 环境..."

    if ! command -v docker &> /dev/null; then
        log_error "Docker 未安装，请先安装 Docker"
        exit 1
    fi

    if ! docker compose version &> /dev/null; then
        log_error "Docker Compose 未安装或版本过低，请安装 Docker Compose V2"
        exit 1
    fi

    log_success "Docker 环境检查通过"
}

# 创建目录结构
create_directories() {
    log_info "创建必要的目录结构..."

    # 定义所有需要的目录
    directories=(
        "$HOME/violet/mnt/redis/data"
        "$HOME/violet/mnt/kvrocks"
        "$HOME/violet/mnt/kafka/connectors"
        "$HOME/violet/mnt/mysql/data"
        "$HOME/violet/mnt/mysql/config"
        "$HOME/violet/mnt/milvus/data"
        "$HOME/violet/mnt/milvus/config"
        "$HOME/violet/mnt/nebula/data/meta0"
        "$HOME/violet/mnt/nebula/data/storage0"
        "$HOME/violet/mnt/nebula/logs/meta0"
        "$HOME/violet/mnt/nebula/logs/storage0"
        "$HOME/violet/mnt/nebula/logs/graph"
    )

    for dir in "${directories[@]}"; do
        if [ ! -d "$dir" ]; then
            mkdir -p "$dir"
            log_success "创建目录: $dir"
        else
            log_warning "目录已存在: $dir"
        fi
    done

    # 设置正确的权限（特别是 Kafka 需要 1000:1000）
    chown -R 1000:1000 "$HOME/violet/mnt/kafka" 2>/dev/null || true

    log_success "目录结构创建完成"
}

# 检查并复制配置文件
copy_config_files() {
    log_info "检查配置文件..."

    REQUIREMENT_DIR="$HOME/violet/requirement"

    # 检查 requirement 目录是否存在
    if [ ! -d "$REQUIREMENT_DIR" ]; then
        log_error "找不到 requirement 目录: $REQUIREMENT_DIR"
        log_info "请确保以下文件存在于 ~/violet/requirement/ 目录："
        echo "  - embedEtcd.yaml"
        echo "  - user.yaml"
        echo "  - mysql-violet.sql"
        echo "  - connectors/ (目录)"
        exit 1
    fi

    # 检查必需文件
    required_files=(
        "$REQUIREMENT_DIR/embedEtcd.yaml"
        "$REQUIREMENT_DIR/user.yaml"
        "$REQUIREMENT_DIR/mysql-violet.sql"
    )

    missing_files=0
    for file in "${required_files[@]}"; do
        if [ ! -f "$file" ]; then
            log_error "缺少文件: $file"
            missing_files=$((missing_files + 1))
        fi
    done

    if [ ! -d "$REQUIREMENT_DIR/connectors" ]; then
        log_warning "找不到 connectors 目录: $REQUIREMENT_DIR/connectors"
        log_info "将创建空的 connectors 目录"
    fi

    if [ $missing_files -gt 0 ]; then
        log_error "缺少 $missing_files 个必需文件，请检查 requirement 目录"
        exit 1
    fi

    log_info "复制配置文件到目标目录..."

    # 复制 Milvus 配置
    cp "$REQUIREMENT_DIR/embedEtcd.yaml" "$HOME/violet/mnt/milvus/config/"
    cp "$REQUIREMENT_DIR/user.yaml" "$HOME/violet/mnt/milvus/config/"
    log_success "✓ Milvus 配置文件"

    # 复制 MySQL 初始化脚本
    cp "$REQUIREMENT_DIR/mysql-violet.sql" "$HOME/violet/mnt/mysql/config/"
    log_success "✓ MySQL 初始化脚本"

    # 复制或创建 connectors 目录
    if [ -d "$REQUIREMENT_DIR/connectors" ]; then
        # 如果 connectors 有内容，复制过去
        if [ "$(ls -A $REQUIREMENT_DIR/connectors)" ]; then
            cp -r "$REQUIREMENT_DIR/connectors/"* "$HOME/violet/mnt/kafka/connectors/"
            log_success "✓ Kafka Connectors"
        else
            log_warning "connectors 目录为空，将使用默认配置"
        fi
    fi

    log_success "配置文件复制完成"
}

# 拉取所有镜像
pull_images() {
    log_info "开始拉取 Docker 镜像（这可能需要一些时间）..."

    images=(
        "redis:5.0.14"
        "apache/kvrocks:2.13.0"
        "apache/kafka:4.0.0"
        "debezium/connect:2.7.3.Final"
        "mysql:8.0.35-bullseye"
        "milvusdb/milvus:v2.6.4"
        "vesoft/nebula-metad:v3.8.0"
        "vesoft/nebula-storaged:v3.8.0"
        "vesoft/nebula-graphd:v3.8.0"
        "vesoft/nebula-console:nightly"
        "vesoft/nebula-graph-studio:v3.10.0"
    )

    for image in "${images[@]}"; do
        log_info "拉取镜像: $image"
        if docker pull "$image"; then
            log_success "✓ $image"
        else
            log_error "✗ $image 拉取失败"
            exit 1
        fi
    done

    log_success "所有镜像拉取完成"
}

# 启动服务
start_services() {
    log_info "启动 Violet 服务..."

    cd "$HOME/violet" || exit 1

    # 检查 docker-compose 文件是否存在
    if [ ! -f "violet-docker-compose.yaml" ]; then
        log_error "找不到 violet-docker-compose.yaml 文件"
        log_info "请将 docker-compose 文件放在 $HOME/violet/ 目录下"
        exit 1
    fi

    # 启动服务
    docker compose -f violet-docker-compose.yaml up -d

    log_success "服务启动完成"
}

# 等待服务健康检查
wait_for_services() {
    log_info "等待服务启动并通过健康检查..."

    echo ""
    log_info "这可能需要 1-3 分钟，请耐心等待..."
    echo ""

    sleep 30

    # 显示服务状态
    docker compose -f "$HOME/violet/violet-docker-compose.yaml" ps
}

# 显示服务访问信息
show_access_info() {
    echo ""
    log_success "=========================================="
    log_success "Violet 服务部署完成！"
    log_success "=========================================="
    echo ""
    echo "📦 服务访问信息："
    echo ""
    echo "  Redis:               localhost:6379"
    echo "  Kvrocks:            localhost:6666"
    echo "  Kafka (内部):        localhost:9092"
    echo "  Kafka (外部):        localhost:9094"
    echo "  Kafka Connect:       http://localhost:8083"
    echo "  MySQL:               localhost:3306 (root/root)"
    echo "  Milvus:              localhost:19530"
    echo "  Nebula Graph:        localhost:9669 (root/nebula)"
    echo "  Nebula Studio:       http://localhost:7001"
    echo ""
    echo "📝 常用命令："
    echo ""
    echo "  查看服务状态:   docker compose -f ~/violet/violet-docker-compose.yaml ps"
    echo "  查看日志:       docker compose -f ~/violet/violet-docker-compose.yaml logs -f [服务名]"
    echo "  停止服务:       docker compose -f ~/violet/violet-docker-compose.yaml down"
    echo "  重启服务:       docker compose -f ~/violet/violet-docker-compose.yaml restart [服务名]"
    echo ""
    echo "🔍 Nebula Graph 连接："
    echo ""
    echo "  docker run --rm -ti --network violet_violet_net vesoft/nebula-console:nightly \\"
    echo "    -addr graphd -port 9669 -u root -p nebula"
    echo ""
    log_info "提示：首次启动 Nebula Graph 需要等待 storage-activator 完成初始化"
    echo ""
}

# 主函数
main() {
    log_info "开始初始化 Violet 项目环境..."
    echo ""

    # 检查环境
    check_docker

    # 创建目录
    create_directories

    # 复制配置文件
    copy_config_files

    # 拉取镜像
    read -p "是否现在拉取 Docker 镜像？(y/n) " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        pull_images
    else
        log_warning "跳过镜像拉取，请确保镜像已存在"
    fi

    # 启动服务
    echo ""
    read -p "是否现在启动服务？(y/n) " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        start_services
        wait_for_services
        show_access_info
    else
        log_info "跳过服务启动"
        log_info "稍后可使用以下命令手动启动："
        echo "  cd ~/violet && docker compose -f violet-docker-compose.yaml up -d"
    fi

    log_success "初始化完成！"
}

# 执行主函数
main