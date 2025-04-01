package violet.gateway.common.proto_gen.im;

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
        comments = "Source: proto/im.proto")
public final class IMServiceGrpc {

    private IMServiceGrpc() {
    }

    public static final String SERVICE_NAME = "im.IMService";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.SendMessageRequest,
            violet.gateway.common.proto_gen.im.SendMessageResponse> METHOD_SEND_MESSAGE =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.SendMessageRequest, violet.gateway.common.proto_gen.im.SendMessageResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "SendMessage"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.SendMessageRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.SendMessageResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.GetMessageByInitRequest,
            violet.gateway.common.proto_gen.im.GetMessageByInitResponse> METHOD_GET_MESSAGE_BY_INIT =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.GetMessageByInitRequest, violet.gateway.common.proto_gen.im.GetMessageByInitResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "GetMessageByInit"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetMessageByInitRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetMessageByInitResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.GetMessageByConversationRequest,
            violet.gateway.common.proto_gen.im.GetMessageByConversationResponse> METHOD_GET_MESSAGE_BY_CONVERSATION =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.GetMessageByConversationRequest, violet.gateway.common.proto_gen.im.GetMessageByConversationResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "GetMessageByConversation"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetMessageByConversationRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetMessageByConversationResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.MarkReadRequest,
            violet.gateway.common.proto_gen.im.MarkReadResponse> METHOD_MARK_READ =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.MarkReadRequest, violet.gateway.common.proto_gen.im.MarkReadResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "MarkRead"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.MarkReadRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.MarkReadResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.CreateConversationRequest,
            violet.gateway.common.proto_gen.im.CreateConversationResponse> METHOD_CREATE_CONVERSATION =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.CreateConversationRequest, violet.gateway.common.proto_gen.im.CreateConversationResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "CreateConversation"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.CreateConversationRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.CreateConversationResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.GetConversationMembersRequest,
            violet.gateway.common.proto_gen.im.GetConversationMemberResponse> METHOD_GET_CONVERSATION_MEMBERS =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.GetConversationMembersRequest, violet.gateway.common.proto_gen.im.GetConversationMemberResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "GetConversationMembers"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetConversationMembersRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.GetConversationMemberResponse.getDefaultInstance()))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<violet.gateway.common.proto_gen.im.AddConversationMembersRequest,
            violet.gateway.common.proto_gen.im.AddConversationMembersResponse> METHOD_ADD_CONVERSATION_MEMBERS =
            io.grpc.MethodDescriptor.<violet.gateway.common.proto_gen.im.AddConversationMembersRequest, violet.gateway.common.proto_gen.im.AddConversationMembersResponse>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "im.IMService", "AddConversationMembers"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.AddConversationMembersRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            violet.gateway.common.proto_gen.im.AddConversationMembersResponse.getDefaultInstance()))
                    .build();

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static IMServiceStub newStub(io.grpc.Channel channel) {
        return new IMServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static IMServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new IMServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static IMServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new IMServiceFutureStub(channel);
    }

    /**
     *
     */
    public static abstract class IMServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void sendMessage(violet.gateway.common.proto_gen.im.SendMessageRequest request,
                                io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.SendMessageResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
        }

        /**
         *
         */
        public void getMessageByInit(violet.gateway.common.proto_gen.im.GetMessageByInitRequest request,
                                     io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByInitResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_MESSAGE_BY_INIT, responseObserver);
        }

        /**
         *
         */
        public void getMessageByConversation(violet.gateway.common.proto_gen.im.GetMessageByConversationRequest request,
                                             io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByConversationResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_MESSAGE_BY_CONVERSATION, responseObserver);
        }

        /**
         *
         */
        public void markRead(violet.gateway.common.proto_gen.im.MarkReadRequest request,
                             io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.MarkReadResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_MARK_READ, responseObserver);
        }

        /**
         *
         */
        public void createConversation(violet.gateway.common.proto_gen.im.CreateConversationRequest request,
                                       io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.CreateConversationResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_CREATE_CONVERSATION, responseObserver);
        }

        /**
         *
         */
        public void getConversationMembers(violet.gateway.common.proto_gen.im.GetConversationMembersRequest request,
                                           io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetConversationMemberResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_CONVERSATION_MEMBERS, responseObserver);
        }

        /**
         *
         */
        public void addConversationMembers(violet.gateway.common.proto_gen.im.AddConversationMembersRequest request,
                                           io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.AddConversationMembersResponse> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_ADD_CONVERSATION_MEMBERS, responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            METHOD_SEND_MESSAGE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.SendMessageRequest,
                                            violet.gateway.common.proto_gen.im.SendMessageResponse>(
                                            this, METHODID_SEND_MESSAGE)))
                    .addMethod(
                            METHOD_GET_MESSAGE_BY_INIT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.GetMessageByInitRequest,
                                            violet.gateway.common.proto_gen.im.GetMessageByInitResponse>(
                                            this, METHODID_GET_MESSAGE_BY_INIT)))
                    .addMethod(
                            METHOD_GET_MESSAGE_BY_CONVERSATION,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.GetMessageByConversationRequest,
                                            violet.gateway.common.proto_gen.im.GetMessageByConversationResponse>(
                                            this, METHODID_GET_MESSAGE_BY_CONVERSATION)))
                    .addMethod(
                            METHOD_MARK_READ,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.MarkReadRequest,
                                            violet.gateway.common.proto_gen.im.MarkReadResponse>(
                                            this, METHODID_MARK_READ)))
                    .addMethod(
                            METHOD_CREATE_CONVERSATION,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.CreateConversationRequest,
                                            violet.gateway.common.proto_gen.im.CreateConversationResponse>(
                                            this, METHODID_CREATE_CONVERSATION)))
                    .addMethod(
                            METHOD_GET_CONVERSATION_MEMBERS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.GetConversationMembersRequest,
                                            violet.gateway.common.proto_gen.im.GetConversationMemberResponse>(
                                            this, METHODID_GET_CONVERSATION_MEMBERS)))
                    .addMethod(
                            METHOD_ADD_CONVERSATION_MEMBERS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            violet.gateway.common.proto_gen.im.AddConversationMembersRequest,
                                            violet.gateway.common.proto_gen.im.AddConversationMembersResponse>(
                                            this, METHODID_ADD_CONVERSATION_MEMBERS)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class IMServiceStub extends io.grpc.stub.AbstractStub<IMServiceStub> {
        private IMServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IMServiceStub(io.grpc.Channel channel,
                              io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IMServiceStub build(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            return new IMServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void sendMessage(violet.gateway.common.proto_gen.im.SendMessageRequest request,
                                io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.SendMessageResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getMessageByInit(violet.gateway.common.proto_gen.im.GetMessageByInitRequest request,
                                     io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByInitResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_MESSAGE_BY_INIT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getMessageByConversation(violet.gateway.common.proto_gen.im.GetMessageByConversationRequest request,
                                             io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByConversationResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_MESSAGE_BY_CONVERSATION, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void markRead(violet.gateway.common.proto_gen.im.MarkReadRequest request,
                             io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.MarkReadResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_MARK_READ, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void createConversation(violet.gateway.common.proto_gen.im.CreateConversationRequest request,
                                       io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.CreateConversationResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_CREATE_CONVERSATION, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getConversationMembers(violet.gateway.common.proto_gen.im.GetConversationMembersRequest request,
                                           io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetConversationMemberResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_CONVERSATION_MEMBERS, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void addConversationMembers(violet.gateway.common.proto_gen.im.AddConversationMembersRequest request,
                                           io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.AddConversationMembersResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_ADD_CONVERSATION_MEMBERS, getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class IMServiceBlockingStub extends io.grpc.stub.AbstractStub<IMServiceBlockingStub> {
        private IMServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IMServiceBlockingStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IMServiceBlockingStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new IMServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.SendMessageResponse sendMessage(violet.gateway.common.proto_gen.im.SendMessageRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.GetMessageByInitResponse getMessageByInit(violet.gateway.common.proto_gen.im.GetMessageByInitRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_MESSAGE_BY_INIT, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.GetMessageByConversationResponse getMessageByConversation(violet.gateway.common.proto_gen.im.GetMessageByConversationRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_MESSAGE_BY_CONVERSATION, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.MarkReadResponse markRead(violet.gateway.common.proto_gen.im.MarkReadRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_MARK_READ, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.CreateConversationResponse createConversation(violet.gateway.common.proto_gen.im.CreateConversationRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_CREATE_CONVERSATION, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.GetConversationMemberResponse getConversationMembers(violet.gateway.common.proto_gen.im.GetConversationMembersRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_CONVERSATION_MEMBERS, getCallOptions(), request);
        }

        /**
         *
         */
        public violet.gateway.common.proto_gen.im.AddConversationMembersResponse addConversationMembers(violet.gateway.common.proto_gen.im.AddConversationMembersRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_ADD_CONVERSATION_MEMBERS, getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class IMServiceFutureStub extends io.grpc.stub.AbstractStub<IMServiceFutureStub> {
        private IMServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private IMServiceFutureStub(io.grpc.Channel channel,
                                    io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IMServiceFutureStub build(io.grpc.Channel channel,
                                            io.grpc.CallOptions callOptions) {
            return new IMServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.SendMessageResponse> sendMessage(
                violet.gateway.common.proto_gen.im.SendMessageRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.GetMessageByInitResponse> getMessageByInit(
                violet.gateway.common.proto_gen.im.GetMessageByInitRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_MESSAGE_BY_INIT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.GetMessageByConversationResponse> getMessageByConversation(
                violet.gateway.common.proto_gen.im.GetMessageByConversationRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_MESSAGE_BY_CONVERSATION, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.MarkReadResponse> markRead(
                violet.gateway.common.proto_gen.im.MarkReadRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_MARK_READ, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.CreateConversationResponse> createConversation(
                violet.gateway.common.proto_gen.im.CreateConversationRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_CREATE_CONVERSATION, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.GetConversationMemberResponse> getConversationMembers(
                violet.gateway.common.proto_gen.im.GetConversationMembersRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_CONVERSATION_MEMBERS, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<violet.gateway.common.proto_gen.im.AddConversationMembersResponse> addConversationMembers(
                violet.gateway.common.proto_gen.im.AddConversationMembersRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_ADD_CONVERSATION_MEMBERS, getCallOptions()), request);
        }
    }

    private static final int METHODID_SEND_MESSAGE = 0;
    private static final int METHODID_GET_MESSAGE_BY_INIT = 1;
    private static final int METHODID_GET_MESSAGE_BY_CONVERSATION = 2;
    private static final int METHODID_MARK_READ = 3;
    private static final int METHODID_CREATE_CONVERSATION = 4;
    private static final int METHODID_GET_CONVERSATION_MEMBERS = 5;
    private static final int METHODID_ADD_CONVERSATION_MEMBERS = 6;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final IMServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(IMServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SEND_MESSAGE:
                    serviceImpl.sendMessage((violet.gateway.common.proto_gen.im.SendMessageRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.SendMessageResponse>) responseObserver);
                    break;
                case METHODID_GET_MESSAGE_BY_INIT:
                    serviceImpl.getMessageByInit((violet.gateway.common.proto_gen.im.GetMessageByInitRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByInitResponse>) responseObserver);
                    break;
                case METHODID_GET_MESSAGE_BY_CONVERSATION:
                    serviceImpl.getMessageByConversation((violet.gateway.common.proto_gen.im.GetMessageByConversationRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetMessageByConversationResponse>) responseObserver);
                    break;
                case METHODID_MARK_READ:
                    serviceImpl.markRead((violet.gateway.common.proto_gen.im.MarkReadRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.MarkReadResponse>) responseObserver);
                    break;
                case METHODID_CREATE_CONVERSATION:
                    serviceImpl.createConversation((violet.gateway.common.proto_gen.im.CreateConversationRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.CreateConversationResponse>) responseObserver);
                    break;
                case METHODID_GET_CONVERSATION_MEMBERS:
                    serviceImpl.getConversationMembers((violet.gateway.common.proto_gen.im.GetConversationMembersRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.GetConversationMemberResponse>) responseObserver);
                    break;
                case METHODID_ADD_CONVERSATION_MEMBERS:
                    serviceImpl.addConversationMembers((violet.gateway.common.proto_gen.im.AddConversationMembersRequest) request,
                            (io.grpc.stub.StreamObserver<violet.gateway.common.proto_gen.im.AddConversationMembersResponse>) responseObserver);
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

    private static final class IMServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return violet.gateway.common.proto_gen.im.Im.getDescriptor();
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (IMServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new IMServiceDescriptorSupplier())
                            .addMethod(METHOD_SEND_MESSAGE)
                            .addMethod(METHOD_GET_MESSAGE_BY_INIT)
                            .addMethod(METHOD_GET_MESSAGE_BY_CONVERSATION)
                            .addMethod(METHOD_MARK_READ)
                            .addMethod(METHOD_CREATE_CONVERSATION)
                            .addMethod(METHOD_GET_CONVERSATION_MEMBERS)
                            .addMethod(METHOD_ADD_CONVERSATION_MEMBERS)
                            .build();
                }
            }
        }
        return result;
    }
}
