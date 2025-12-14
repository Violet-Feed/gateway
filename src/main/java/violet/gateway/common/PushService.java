package violet.gateway.common;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import violet.gateway.common.netty.NettyServerHandler;
import violet.gateway.common.proto_gen.push.PushRequest;
import violet.gateway.common.proto_gen.push.PushResponse;
import violet.gateway.common.proto_gen.push.PushServiceGrpc;

@Slf4j
@GrpcService
public class PushService extends PushServiceGrpc.PushServiceImplBase {

    @Override
    public void push(PushRequest request, StreamObserver<PushResponse> responseObserver) {
        try {
            responseObserver.onNext(NettyServerHandler.push(request));
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("push error", e);
            responseObserver.onError(e);
        }
    }
}
