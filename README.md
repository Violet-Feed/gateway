##### linux:

- 启动canal-deployer：~/canal.deployer-1.1.5/bin/startup.sh

- 启动canal-adapter：~/canal.adapter-1.1.5/bin/startup.sh

- 启动es：~/elasticsearch-7.9.2/bin/elasticsearch

- 启动neo4j：~/neo4j-community-3.5.9/bin/neo4j start

- 启动redis：redis-server

- 启动kvrocks：./kvrocks/build/kvrocks -c ./kvrocks/kvrocks.conf

- 启动rocketmq-nameserver：nohup sh ./rocketmq-all-5.3.0-source-release/distribution/target/rocketmq-5.3.0/rocketmq-5.3.0/bin/mqnamesrv &

- 启动rocketmq-broker：nohup sh ./rocketmq-all-5.3.0-source-release/distribution/target/rocketmq-5.3.0/rocketmq-5.3.0/bin/mqbroker -n localhost:9876 &


rocketmq创建topic：./rocketmq-all-5.3.0-source-release/distribution/target/rocketmq-5.3.0/rocketmq-5.3.0/bin/mqadmin updateTopic -n localhost:9876 -b localhost:10911 -t user

##### windows:

start.bat

```bash
@echo off
start "redis-server" "D:\Program\Redis-x64-5.0.14.1\redis-server.exe"
start "mqnamesrv" "D:\Program\rocketmq-all-5.2.0-bin-release\bin\mqnamesrv.cmd"
start "mqbroker" "D:\Program\rocketmq-all-5.2.0-bin-release\bin\mqbroker.cmd" -n localhost:9876
start "neo4j" "D:\Program\neo4j-community-3.5.9\bin\neo4j.bat" console
start "elasticsearch" "D:\Program\elasticsearch-7.9.2\bin\elasticsearch.bat"
start "canal.deployer" cmd /c "cd /d D:\Program\canal.deployer-1.1.5\bin && startup.bat"
start "canal.adapter" cmd /c "cd /d D:\Program\canal.adapter-1.1.5\bin && startup.bat"
```

##### 暂时无法解决的良性bug：

- IM服务邀请群成员采用先入库和读索引后写mq的方式可能会导致用户获取到入群之前的消息；先写mq会导致群聊上限错误无法即时反馈

##### TODO:
1. follow更新缓存，follow_count缓存，follow_list分页，抛异常,锁？
2. createConversation功能
3. markRead，getMessageByUser接口
4. 群组信息
5. AIChat，语音功能
6. notice功能
7. digg,comment,favorite功能 
8. 图片OSS 
9. 商城