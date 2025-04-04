package violet.gateway.common;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import violet.gateway.common.netty.NettyServerHandler;
import violet.gateway.common.proto_gen.push.PushRequest;
import violet.gateway.common.proto_gen.push.PushResponse;
import violet.gateway.common.proto_gen.push.PushServiceGrpc;

@GrpcService
public class PushService extends PushServiceGrpc.PushServiceImplBase {

    @Override
    public void push(PushRequest request, StreamObserver<PushResponse> responseObserver) {
        PushResponse resp = NettyServerHandler.push(request);
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
