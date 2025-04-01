package violet.gateway.common.proto_gen.push;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.6.1)",
        comments = "Source: proto/push.proto")
public final class PushServiceGrpc {

    private PushServiceGrpc() {
    }

    public static final String SERVICE_NAME = "push.PushService";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.push.PushRequest,
            violet.gateway.common.proto_gen.push.PushResponse> METHOD_PUSH =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.push.PushRequest, violet.gateway.common.proto_gen.push.PushResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "push.PushService", "Push"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.push.PushRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.push.PushResponse.getDefaultInstance()))
                    .build();

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static PushServiceStub newStub(io.grpc.Channel channel) {
        return new PushServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static PushServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new PushServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static PushServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new PushServiceFutureStub(channel);
    }

    /**
     *
     */
    public static abstract class PushServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void push(violet.gateway.common.proto_gen.push.PushRequest request,
                         io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.push.PushResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_PUSH, responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            METHOD_PUSH,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.push.PushRequest,
                                            violet.gateway.common.proto_gen.push.PushResponse>(
                                            this, METHODID_PUSH)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class PushServiceStub extends io.grpc.stub.AbstractStub<PushServiceStub> {
        private PushServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private PushServiceStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected PushServiceStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            return new PushServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void push(violet.gateway.common.proto_gen.push.PushRequest request,
                         io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.push.PushResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_PUSH, getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class PushServiceBlockingStub extends io.grpc.stub.AbstractStub<PushServiceBlockingStub> {
        private PushServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private PushServiceBlockingStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected PushServiceBlockingStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new PushServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.push.PushResponse push(violet.gateway.common.proto_gen.push.PushRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_PUSH, getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class PushServiceFutureStub extends io.grpc.stub.AbstractStub<PushServiceFutureStub> {
        private PushServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private PushServiceFutureStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected PushServiceFutureStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new PushServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.push.PushResponse> push(
                violet.gateway.common.proto_gen.push.PushRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_PUSH, getCallOptions()), request);
        }
    }

    private static final int METHODID_PUSH = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final PushServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(PushServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_PUSH:
                    serviceImpl.push((violet.gateway.common.proto_gen.push.PushRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.push.PushResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static final class PushServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return violet.gateway.common.proto_gen.push.Push.getDescriptor();
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (PushServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new PushServiceDescriptorSupplier())
                            .addMethod(METHOD_PUSH)
                            .build();
                }
            }
        }
        return result;
    }
}
