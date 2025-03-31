// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

/**
 * Protobuf type {@code im.GetConversationMemberResponse}
 */
public final class GetConversationMemberResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:im.GetConversationMemberResponse)
        GetConversationMemberResponseOrBuilder {
    // Use GetConversationMemberResponse.newBuilder() to construct.
    private GetConversationMemberResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private GetConversationMemberResponse() {
        userInfos_ = java.util.Collections.emptyList();
        nextCursor_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    private GetConversationMemberResponse(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        int mutable_bitField0_ = 0;
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!input.skipField(tag)) {
                            done = true;
                        }
                        break;
                    }
                    case 10: {
                        if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                            userInfos_ = new java.util.ArrayList<violet.gateway.common.proto_gen.im.ConversationUserInfo>();
                            mutable_bitField0_ |= 0x00000001;
                        }
                        userInfos_.add(
                                input.readMessage(violet.gateway.common.proto_gen.im.ConversationUserInfo.parser(), extensionRegistry));
                        break;
                    }
                    case 16: {

                        nextCursor_ = input.readInt64();
                        break;
                    }
                    case 2042: {
                        violet.gateway.common.proto_gen.common.BaseResp.Builder subBuilder = null;
                        if (baseResp_ != null) {
                            subBuilder = baseResp_.toBuilder();
                        }
                        baseResp_ = input.readMessage(violet.gateway.common.proto_gen.common.BaseResp.parser(), extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(baseResp_);
                            baseResp_ = subBuilder.buildPartial();
                        }

                        break;
                    }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(
                    e).setUnfinishedMessage(this);
        } finally {
            if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                userInfos_ = java.util.Collections.unmodifiableList(userInfos_);
            }
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return violet.gateway.common.proto_gen.im.Im.internal_static_im_GetConversationMemberResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return violet.gateway.common.proto_gen.im.Im.internal_static_im_GetConversationMemberResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        violet.gateway.common.proto_gen.im.GetConversationMemberResponse.class, violet.gateway.common.proto_gen.im.GetConversationMemberResponse.Builder.class);
    }

    private int bitField0_;
    public static final int USER_INFOS_FIELD_NUMBER = 1;
    private java.util.List<violet.gateway.common.proto_gen.im.ConversationUserInfo> userInfos_;

    /**
     * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
     */
    public java.util.List<violet.gateway.common.proto_gen.im.ConversationUserInfo> getUserInfosList() {
        return userInfos_;
    }

    /**
     * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
     */
    public java.util.List<? extends violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder>
    getUserInfosOrBuilderList() {
        return userInfos_;
    }

    /**
     * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
     */
    public int getUserInfosCount() {
        return userInfos_.size();
    }

    /**
     * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.im.ConversationUserInfo getUserInfos(int index) {
        return userInfos_.get(index);
    }

    /**
     * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder getUserInfosOrBuilder(
            int index) {
        return userInfos_.get(index);
    }

    public static final int NEXT_CURSOR_FIELD_NUMBER = 2;
    private long nextCursor_;

    /**
     * <code>int64 next_cursor = 2;</code>
     */
    public long getNextCursor() {
        return nextCursor_;
    }

    public static final int BASERESP_FIELD_NUMBER = 255;
    private violet.gateway.common.proto_gen.common.BaseResp baseResp_;

    /**
     * <code>.common.BaseResp baseResp = 255;</code>
     */
    public boolean hasBaseResp() {
        return baseResp_ != null;
    }

    /**
     * <code>.common.BaseResp baseResp = 255;</code>
     */
    public violet.gateway.common.proto_gen.common.BaseResp getBaseResp() {
        return baseResp_ == null ? violet.gateway.common.proto_gen.common.BaseResp.getDefaultInstance() : baseResp_;
    }

    /**
     * <code>.common.BaseResp baseResp = 255;</code>
     */
    public violet.gateway.common.proto_gen.common.BaseRespOrBuilder getBaseRespOrBuilder() {
        return getBaseResp();
    }

    private byte memoizedIsInitialized = -1;

    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        for (int i = 0; i < userInfos_.size(); i++) {
            output.writeMessage(1, userInfos_.get(i));
        }
        if (nextCursor_ != 0L) {
            output.writeInt64(2, nextCursor_);
        }
        if (baseResp_ != null) {
            output.writeMessage(255, getBaseResp());
        }
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        for (int i = 0; i < userInfos_.size(); i++) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(1, userInfos_.get(i));
        }
        if (nextCursor_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeInt64Size(2, nextCursor_);
        }
        if (baseResp_ != null) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(255, getBaseResp());
        }
        memoizedSize = size;
        return size;
    }

    private static final long serialVersionUID = 0L;

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof violet.gateway.common.proto_gen.im.GetConversationMemberResponse)) {
            return super.equals(obj);
        }
        violet.gateway.common.proto_gen.im.GetConversationMemberResponse other = (violet.gateway.common.proto_gen.im.GetConversationMemberResponse) obj;

        boolean result = true;
        result = result && getUserInfosList()
                .equals(other.getUserInfosList());
        result = result && (getNextCursor()
                == other.getNextCursor());
        result = result && (hasBaseResp() == other.hasBaseResp());
        if (hasBaseResp()) {
            result = result && getBaseResp()
                    .equals(other.getBaseResp());
        }
        return result;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        if (getUserInfosCount() > 0) {
            hash = (37 * hash) + USER_INFOS_FIELD_NUMBER;
            hash = (53 * hash) + getUserInfosList().hashCode();
        }
        hash = (37 * hash) + NEXT_CURSOR_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getNextCursor());
        if (hasBaseResp()) {
            hash = (37 * hash) + BASERESP_FIELD_NUMBER;
            hash = (53 * hash) + getBaseResp().hashCode();
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(violet.gateway.common.proto_gen.im.GetConversationMemberResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * Protobuf type {@code im.GetConversationMemberResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:im.GetConversationMemberResponse)
            violet.gateway.common.proto_gen.im.GetConversationMemberResponseOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return violet.gateway.common.proto_gen.im.Im.internal_static_im_GetConversationMemberResponse_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return violet.gateway.common.proto_gen.im.Im.internal_static_im_GetConversationMemberResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            violet.gateway.common.proto_gen.im.GetConversationMemberResponse.class, violet.gateway.common.proto_gen.im.GetConversationMemberResponse.Builder.class);
        }

        // Construct using violet.gateway.common.proto_gen.im.GetConversationMemberResponse.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
                getUserInfosFieldBuilder();
            }
        }

        public Builder clear() {
            super.clear();
            if (userInfosBuilder_ == null) {
                userInfos_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
            } else {
                userInfosBuilder_.clear();
            }
            nextCursor_ = 0L;

            if (baseRespBuilder_ == null) {
                baseResp_ = null;
            } else {
                baseResp_ = null;
                baseRespBuilder_ = null;
            }
            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return violet.gateway.common.proto_gen.im.Im.internal_static_im_GetConversationMemberResponse_descriptor;
        }

        public violet.gateway.common.proto_gen.im.GetConversationMemberResponse getDefaultInstanceForType() {
            return violet.gateway.common.proto_gen.im.GetConversationMemberResponse.getDefaultInstance();
        }

        public violet.gateway.common.proto_gen.im.GetConversationMemberResponse build() {
            violet.gateway.common.proto_gen.im.GetConversationMemberResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public violet.gateway.common.proto_gen.im.GetConversationMemberResponse buildPartial() {
            violet.gateway.common.proto_gen.im.GetConversationMemberResponse result = new violet.gateway.common.proto_gen.im.GetConversationMemberResponse(this);
            int from_bitField0_ = bitField0_;
            int to_bitField0_ = 0;
            if (userInfosBuilder_ == null) {
                if (((bitField0_ & 0x00000001) == 0x00000001)) {
                    userInfos_ = java.util.Collections.unmodifiableList(userInfos_);
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.userInfos_ = userInfos_;
            } else {
                result.userInfos_ = userInfosBuilder_.build();
            }
            result.nextCursor_ = nextCursor_;
            if (baseRespBuilder_ == null) {
                result.baseResp_ = baseResp_;
            } else {
                result.baseResp_ = baseRespBuilder_.build();
            }
            result.bitField0_ = to_bitField0_;
            onBuilt();
            return result;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return (Builder) super.setField(field, value);
        }

        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return (Builder) super.clearField(field);
        }

        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return (Builder) super.clearOneof(oneof);
        }

        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, Object value) {
            return (Builder) super.setRepeatedField(field, index, value);
        }

        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return (Builder) super.addRepeatedField(field, value);
        }

        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof violet.gateway.common.proto_gen.im.GetConversationMemberResponse) {
                return mergeFrom((violet.gateway.common.proto_gen.im.GetConversationMemberResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(violet.gateway.common.proto_gen.im.GetConversationMemberResponse other) {
            if (other == violet.gateway.common.proto_gen.im.GetConversationMemberResponse.getDefaultInstance())
                return this;
            if (userInfosBuilder_ == null) {
                if (!other.userInfos_.isEmpty()) {
                    if (userInfos_.isEmpty()) {
                        userInfos_ = other.userInfos_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureUserInfosIsMutable();
                        userInfos_.addAll(other.userInfos_);
                    }
                    onChanged();
                }
            } else {
                if (!other.userInfos_.isEmpty()) {
                    if (userInfosBuilder_.isEmpty()) {
                        userInfosBuilder_.dispose();
                        userInfosBuilder_ = null;
                        userInfos_ = other.userInfos_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                        userInfosBuilder_ =
                                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                        getUserInfosFieldBuilder() : null;
                    } else {
                        userInfosBuilder_.addAllMessages(other.userInfos_);
                    }
                }
            }
            if (other.getNextCursor() != 0L) {
                setNextCursor(other.getNextCursor());
            }
            if (other.hasBaseResp()) {
                mergeBaseResp(other.getBaseResp());
            }
            onChanged();
            return this;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            violet.gateway.common.proto_gen.im.GetConversationMemberResponse parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (violet.gateway.common.proto_gen.im.GetConversationMemberResponse) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int bitField0_;

        private java.util.List<violet.gateway.common.proto_gen.im.ConversationUserInfo> userInfos_ =
                java.util.Collections.emptyList();

        private void ensureUserInfosIsMutable() {
            if (!((bitField0_ & 0x00000001) == 0x00000001)) {
                userInfos_ = new java.util.ArrayList<violet.gateway.common.proto_gen.im.ConversationUserInfo>(userInfos_);
                bitField0_ |= 0x00000001;
            }
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<
                violet.gateway.common.proto_gen.im.ConversationUserInfo, violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder, violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder> userInfosBuilder_;

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public java.util.List<violet.gateway.common.proto_gen.im.ConversationUserInfo> getUserInfosList() {
            if (userInfosBuilder_ == null) {
                return java.util.Collections.unmodifiableList(userInfos_);
            } else {
                return userInfosBuilder_.getMessageList();
            }
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public int getUserInfosCount() {
            if (userInfosBuilder_ == null) {
                return userInfos_.size();
            } else {
                return userInfosBuilder_.getCount();
            }
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public violet.gateway.common.proto_gen.im.ConversationUserInfo getUserInfos(int index) {
            if (userInfosBuilder_ == null) {
                return userInfos_.get(index);
            } else {
                return userInfosBuilder_.getMessage(index);
            }
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder setUserInfos(
                int index, violet.gateway.common.proto_gen.im.ConversationUserInfo value) {
            if (userInfosBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUserInfosIsMutable();
                userInfos_.set(index, value);
                onChanged();
            } else {
                userInfosBuilder_.setMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder setUserInfos(
                int index, violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder builderForValue) {
            if (userInfosBuilder_ == null) {
                ensureUserInfosIsMutable();
                userInfos_.set(index, builderForValue.build());
                onChanged();
            } else {
                userInfosBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder addUserInfos(violet.gateway.common.proto_gen.im.ConversationUserInfo value) {
            if (userInfosBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUserInfosIsMutable();
                userInfos_.add(value);
                onChanged();
            } else {
                userInfosBuilder_.addMessage(value);
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder addUserInfos(
                int index, violet.gateway.common.proto_gen.im.ConversationUserInfo value) {
            if (userInfosBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUserInfosIsMutable();
                userInfos_.add(index, value);
                onChanged();
            } else {
                userInfosBuilder_.addMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder addUserInfos(
                violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder builderForValue) {
            if (userInfosBuilder_ == null) {
                ensureUserInfosIsMutable();
                userInfos_.add(builderForValue.build());
                onChanged();
            } else {
                userInfosBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder addUserInfos(
                int index, violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder builderForValue) {
            if (userInfosBuilder_ == null) {
                ensureUserInfosIsMutable();
                userInfos_.add(index, builderForValue.build());
                onChanged();
            } else {
                userInfosBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder addAllUserInfos(
                java.lang.Iterable<? extends violet.gateway.common.proto_gen.im.ConversationUserInfo> values) {
            if (userInfosBuilder_ == null) {
                ensureUserInfosIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, userInfos_);
                onChanged();
            } else {
                userInfosBuilder_.addAllMessages(values);
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder clearUserInfos() {
            if (userInfosBuilder_ == null) {
                userInfos_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
            } else {
                userInfosBuilder_.clear();
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public Builder removeUserInfos(int index) {
            if (userInfosBuilder_ == null) {
                ensureUserInfosIsMutable();
                userInfos_.remove(index);
                onChanged();
            } else {
                userInfosBuilder_.remove(index);
            }
            return this;
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder getUserInfosBuilder(
                int index) {
            return getUserInfosFieldBuilder().getBuilder(index);
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder getUserInfosOrBuilder(
                int index) {
            if (userInfosBuilder_ == null) {
                return userInfos_.get(index);
            } else {
                return userInfosBuilder_.getMessageOrBuilder(index);
            }
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public java.util.List<? extends violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder>
        getUserInfosOrBuilderList() {
            if (userInfosBuilder_ != null) {
                return userInfosBuilder_.getMessageOrBuilderList();
            } else {
                return java.util.Collections.unmodifiableList(userInfos_);
            }
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder addUserInfosBuilder() {
            return getUserInfosFieldBuilder().addBuilder(
                    violet.gateway.common.proto_gen.im.ConversationUserInfo.getDefaultInstance());
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder addUserInfosBuilder(
                int index) {
            return getUserInfosFieldBuilder().addBuilder(
                    index, violet.gateway.common.proto_gen.im.ConversationUserInfo.getDefaultInstance());
        }

        /**
         * <code>repeated .im.ConversationUserInfo user_infos = 1;</code>
         */
        public java.util.List<violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder>
        getUserInfosBuilderList() {
            return getUserInfosFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<
                violet.gateway.common.proto_gen.im.ConversationUserInfo, violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder, violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder>
        getUserInfosFieldBuilder() {
            if (userInfosBuilder_ == null) {
                userInfosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                        violet.gateway.common.proto_gen.im.ConversationUserInfo, violet.gateway.common.proto_gen.im.ConversationUserInfo.Builder, violet.gateway.common.proto_gen.im.ConversationUserInfoOrBuilder>(
                        userInfos_,
                        ((bitField0_ & 0x00000001) == 0x00000001),
                        getParentForChildren(),
                        isClean());
                userInfos_ = null;
            }
            return userInfosBuilder_;
        }

        private long nextCursor_;

        /**
         * <code>int64 next_cursor = 2;</code>
         */
        public long getNextCursor() {
            return nextCursor_;
        }

        /**
         * <code>int64 next_cursor = 2;</code>
         */
        public Builder setNextCursor(long value) {

            nextCursor_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>int64 next_cursor = 2;</code>
         */
        public Builder clearNextCursor() {

            nextCursor_ = 0L;
            onChanged();
            return this;
        }

        private violet.gateway.common.proto_gen.common.BaseResp baseResp_ = null;
        private com.google.protobuf.SingleFieldBuilderV3<
                violet.gateway.common.proto_gen.common.BaseResp, violet.gateway.common.proto_gen.common.BaseResp.Builder, violet.gateway.common.proto_gen.common.BaseRespOrBuilder> baseRespBuilder_;

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public boolean hasBaseResp() {
            return baseRespBuilder_ != null || baseResp_ != null;
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public violet.gateway.common.proto_gen.common.BaseResp getBaseResp() {
            if (baseRespBuilder_ == null) {
                return baseResp_ == null ? violet.gateway.common.proto_gen.common.BaseResp.getDefaultInstance() : baseResp_;
            } else {
                return baseRespBuilder_.getMessage();
            }
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public Builder setBaseResp(violet.gateway.common.proto_gen.common.BaseResp value) {
            if (baseRespBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                baseResp_ = value;
                onChanged();
            } else {
                baseRespBuilder_.setMessage(value);
            }

            return this;
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public Builder setBaseResp(
                violet.gateway.common.proto_gen.common.BaseResp.Builder builderForValue) {
            if (baseRespBuilder_ == null) {
                baseResp_ = builderForValue.build();
                onChanged();
            } else {
                baseRespBuilder_.setMessage(builderForValue.build());
            }

            return this;
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public Builder mergeBaseResp(violet.gateway.common.proto_gen.common.BaseResp value) {
            if (baseRespBuilder_ == null) {
                if (baseResp_ != null) {
                    baseResp_ =
                            violet.gateway.common.proto_gen.common.BaseResp.newBuilder(baseResp_).mergeFrom(value).buildPartial();
                } else {
                    baseResp_ = value;
                }
                onChanged();
            } else {
                baseRespBuilder_.mergeFrom(value);
            }

            return this;
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public Builder clearBaseResp() {
            if (baseRespBuilder_ == null) {
                baseResp_ = null;
                onChanged();
            } else {
                baseResp_ = null;
                baseRespBuilder_ = null;
            }

            return this;
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public violet.gateway.common.proto_gen.common.BaseResp.Builder getBaseRespBuilder() {

            onChanged();
            return getBaseRespFieldBuilder().getBuilder();
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        public violet.gateway.common.proto_gen.common.BaseRespOrBuilder getBaseRespOrBuilder() {
            if (baseRespBuilder_ != null) {
                return baseRespBuilder_.getMessageOrBuilder();
            } else {
                return baseResp_ == null ?
                        violet.gateway.common.proto_gen.common.BaseResp.getDefaultInstance() : baseResp_;
            }
        }

        /**
         * <code>.common.BaseResp baseResp = 255;</code>
         */
        private com.google.protobuf.SingleFieldBuilderV3<
                violet.gateway.common.proto_gen.common.BaseResp, violet.gateway.common.proto_gen.common.BaseResp.Builder, violet.gateway.common.proto_gen.common.BaseRespOrBuilder>
        getBaseRespFieldBuilder() {
            if (baseRespBuilder_ == null) {
                baseRespBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                        violet.gateway.common.proto_gen.common.BaseResp, violet.gateway.common.proto_gen.common.BaseResp.Builder, violet.gateway.common.proto_gen.common.BaseRespOrBuilder>(
                        getBaseResp(),
                        getParentForChildren(),
                        isClean());
                baseResp_ = null;
            }
            return baseRespBuilder_;
        }

        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return this;
        }

        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return this;
        }


        // @@protoc_insertion_point(builder_scope:im.GetConversationMemberResponse)
    }

    // @@protoc_insertion_point(class_scope:im.GetConversationMemberResponse)
    private static final violet.gateway.common.proto_gen.im.GetConversationMemberResponse DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.im.GetConversationMemberResponse();
    }

    public static violet.gateway.common.proto_gen.im.GetConversationMemberResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetConversationMemberResponse>
            PARSER = new com.google.protobuf.AbstractParser<GetConversationMemberResponse>() {
        public GetConversationMemberResponse parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new GetConversationMemberResponse(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<GetConversationMemberResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GetConversationMemberResponse> getParserForType() {
        return PARSER;
    }

    public violet.gateway.common.proto_gen.im.GetConversationMemberResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

