#!/usr/bin/env bash
set -euo pipefail

# ===== 基本配置 =====
COMPOSE_FILE="./feed-docker-compose.yaml"   # 你的 docker-compose 文件名
PROJECT_NAME="feed"                         # docker compose -p <project>
DATA_ROOT="${HOME}/dockerD/mnt"             # 数据目录根

# ===== 检查 docker compose 命令 =====
if command -v docker-compose &>/dev/null; then
  COMPOSE_CMD="docker-compose"
elif docker compose version &>/dev/null; then
  COMPOSE_CMD="docker compose"
else
  echo "错误: 需要 docker compose 插件或 docker-compose 可执行文件"
  exit 1
fi

if [[ ! -f "$COMPOSE_FILE" ]]; then
  echo "错误: 未找到 compose 文件: $COMPOSE_FILE"
  exit 1
fi

# ===== 创建必须目录（与 compose 中的挂载路径一致）=====
echo ">> 创建数据目录..."
mkdir -p \
  "${DATA_ROOT}/redis/data" \
  "${DATA_ROOT}/rocketmq/store" \
  "${DATA_ROOT}/rocketmq/logs" \
  "${DATA_ROOT}/neo4j/data" \
  "${DATA_ROOT}/neo4j/logs" \
  "${DATA_ROOT}/neo4j/plugins" \
  "${DATA_ROOT}/es/data" \
  "${DATA_ROOT}/milvus/data" \
  "${DATA_ROOT}/mysql/data" \
  "${DATA_ROOT}/kvrocks/data" \
  "${DATA_ROOT}/kvrocks/conf" \
  "./kafka/connectors" \
  "./rocketmq/conf" \
  "./milvus"

# 目录权限（避免容器内权限问题；Windows/WSL 可忽略失败）
echo ">> 设置目录权限..."
chmod -R 777 "${DATA_ROOT}/redis"       || true
chmod -R 777 "${DATA_ROOT}/rocketmq"    || true
chmod -R 777 "${DATA_ROOT}/neo4j"       || true
chmod -R 777 "${DATA_ROOT}/es"          || true
chmod -R 777 "${DATA_ROOT}/milvus"      || true
chmod -R 777 "${DATA_ROOT}/mysql"       || true
chmod -R 777 "${DATA_ROOT}/kvrocks"     || true

# ===== 准备配置模板 =====
# RocketMQ broker.conf（如果你用 Proxy 的 -bc，就准备个最小模板，后续可自行覆盖）
if [[ ! -f "./rocketmq/conf/broker.conf" ]]; then
  cat > ./rocketmq/conf/broker.conf <<'EOF'
# Minimal broker.conf (用于本地开发，可按需扩展)
brokerClusterName=DefaultCluster
brokerName=broker-a
brokerId=0
listenPort=10911
brokerRole=ASYNC_MASTER
flushDiskType=ASYNC_FLUSH
EOF
  echo ">> 已生成 ./rocketmq/conf/broker.conf"
fi

# Milvus embedEtcd.yaml
if [[ ! -f "./milvus/embedEtcd.yaml" ]]; then
  cat > ./milvus/embedEtcd.yaml <<'EOF'
listen-client-urls: http://0.0.0.0:2379
advertise-client-urls: http://0.0.0.0:2379
quota-backend-bytes: 4294967296
auto-compaction-mode: revision
auto-compaction-retention: '1000'
EOF
  echo ">> 已生成 ./milvus/embedEtcd.yaml"
fi

# Milvus user.yaml（留空模板，按需覆盖默认配置）
if [[ ! -f "./milvus/user.yaml" ]]; then
  cat > ./milvus/user.yaml <<'EOF'
# Extra config to override default milvus.yaml
# storage:
#   type: local
# logs:
#   level: info
EOF
  echo ">> 已生成 ./milvus/user.yaml"
fi

# Kafka Connect 插件说明（占位文件，提醒你把 sink 的 jar 放进来）
if [[ ! -f "./kafka/connectors/README.txt" ]]; then
  cat > ./kafka/connectors/README.txt <<'EOF'
把第三方 Kafka Connect 插件 JAR 放到此目录。
示例：
- Neo4j Sink:   kafka-connect-neo4j/*  或 Neo4j Streams/Connector 对应版本的 jar
- ES Sink:      confluentinc/kafka-connect-elasticsearch 对应版本的 jar
EOF
fi

# Kvrocks 配置（可按需调整）
if [[ ! -f "${DATA_ROOT}/kvrocks/conf/kvrocks.conf" ]]; then
  cat > "${DATA_ROOT}/kvrocks/conf/kvrocks.conf" <<'EOF'
bind 0.0.0.0
port 6666
dir /var/lib/kvrocks
daemonize no
logfile ""
save 900 1
save 300 10
save 60 10000
rocksdb.compression lz4
maxclients 10000
EOF
  echo ">> 已生成 ${DATA_ROOT}/kvrocks/conf/kvrocks.conf"
fi

# ===== 启动 =====
echo ">> 启动服务 (project: ${PROJECT_NAME}) ..."
${COMPOSE_CMD} -f "${COMPOSE_FILE}" -p "${PROJECT_NAME}" up -d

# ===== 简单健康等待 =====
echo ">> 等待关键服务健康探测..."
sleep 5

# 等待函数：等待某容器健康或端口连通
wait_healthy() {
  local name="$1"
  local retries="${2:-40}"
  local interval="${3:-3}"
  echo -n "   - 等待 ${name} 健康"
  for ((i=1; i<=retries; i++)); do
    status="$(docker inspect -f '{{.State.Health.Status}}' "${name}" 2>/dev/null || echo unknown)"
    if [[ "${status}" == "healthy" ]]; then
      echo " -> healthy"
      return 0
    fi
    echo -n "."
    sleep "${interval}"
  done
  echo " -> 超时（当前状态: ${status}）"
  return 1
}

# 仅对声明了 healthcheck 的做等待；其余打印提示
wait_healthy "kafka"                  || true
wait_healthy "kafka-connect"          || true
wait_healthy "feed-elasticsearch"     || true
wait_healthy "feed-neo4j"             || true
wait_healthy "feed-milvus"            || true
wait_healthy "feed-redis"             || true
wait_healthy "feed-rmq-namesrv"       || true
wait_healthy "feed-rmq-proxy"         || true
wait_healthy "feed-mysql"             || true
wait_healthy "feed-kvrocks"           || true

echo ""
echo "🚀 Feed 平台启动完成！"
echo ""
echo "📌 常用端点："
echo "- Kafka Broker (inside):   kafka:9092"
echo "- Kafka Broker (outside):  localhost:9094"
echo "- Kafka Connect REST:      http://localhost:8083"
echo "- Elasticsearch:           http://localhost:9200"
echo "- Neo4j Browser:           http://localhost:7474  (bolt: localhost:7687, neo4j/password)"
echo "- MySQL:                   localhost:3306  (root/root, replicator/StrongPassw0rd!)"
echo "- Redis:                   localhost:6379"
echo "- Kvrocks:                 localhost:6666"
echo "- RocketMQ Namesrv:        localhost:9876"
echo "- RocketMQ Proxy:          http://localhost:8080 / 8081"
echo "- Milvus gRPC:             localhost:19530"
echo "- Milvus HTTP:             http://localhost:9091/healthz"
echo ""
echo "📦 Kafka Connect 插件目录： ./kafka/connectors  (放 Neo4j/ES Sink 的 jar)"
echo "   * 注册 connector 示例：curl -X POST http://localhost:8083/connectors -H 'Content-Type: application/json' -d '{...}'"
echo ""
echo "✅ 提示：首次运行请检查："
echo "   - MySQL 已开启 ROW/FULL binlog（compose 已配置），并确认目标库/表存在"
echo "   - ES 索引模板（mapping/settings）是否预先创建"
echo "   - Neo4j 的 Sink Cypher 映射是否符合你的图模型"
echo "   - Kvrocks 配置在：${DATA_ROOT}/kvrocks/conf/kvrocks.conf"
echo ""

exit 0
