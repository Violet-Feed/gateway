package violet.gateway.common;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import violet.gateway.common.netty.NettyServerHandler;
import violet.gateway.common.proto_gen.push.PushRequest;
import violet.gateway.common.proto_gen.push.PushResponse;
import violet.gateway.common.proto_gen.push.PushServiceGrpc;

@GrpcService
public class PushService extends PushServiceGrpc.PushServiceImplBase {
    @Autowired
    private NettyServerHandler nettyServerHandler;

    @Override
    public void push(PushRequest request, StreamObserver<PushResponse> responseObserver) {
        PushResponse resp=nettyServerHandler.push(request);
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
