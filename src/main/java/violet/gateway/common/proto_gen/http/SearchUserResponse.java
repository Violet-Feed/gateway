// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/http.proto

package violet.gateway.common.proto_gen.http;

/**
 * Protobuf type {@code http.SearchUserResponse}
 */
public  final class SearchUserResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:http.SearchUserResponse)
    SearchUserResponseOrBuilder {
  // Use SearchUserResponse.newBuilder() to construct.
  private SearchUserResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SearchUserResponse() {
    userInfos_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SearchUserResponse(
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
              userInfos_ = new java.util.ArrayList<violet.gateway.common.proto_gen.action.UserInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            userInfos_.add(
                input.readMessage(violet.gateway.common.proto_gen.action.UserInfo.parser(), extensionRegistry));
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
    return violet.gateway.common.proto_gen.http.Http.internal_static_http_SearchUserResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return violet.gateway.common.proto_gen.http.Http.internal_static_http_SearchUserResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            violet.gateway.common.proto_gen.http.SearchUserResponse.class, violet.gateway.common.proto_gen.http.SearchUserResponse.Builder.class);
  }

  public static final int USER_INFOS_FIELD_NUMBER = 1;
  private java.util.List<violet.gateway.common.proto_gen.action.UserInfo> userInfos_;
  /**
   * <code>repeated .action.UserInfo user_infos = 1;</code>
   */
  public java.util.List<violet.gateway.common.proto_gen.action.UserInfo> getUserInfosList() {
    return userInfos_;
  }
  /**
   * <code>repeated .action.UserInfo user_infos = 1;</code>
   */
  public java.util.List<? extends violet.gateway.common.proto_gen.action.UserInfoOrBuilder> 
      getUserInfosOrBuilderList() {
    return userInfos_;
  }
  /**
   * <code>repeated .action.UserInfo user_infos = 1;</code>
   */
  public int getUserInfosCount() {
    return userInfos_.size();
  }
  /**
   * <code>repeated .action.UserInfo user_infos = 1;</code>
   */
  public violet.gateway.common.proto_gen.action.UserInfo getUserInfos(int index) {
    return userInfos_.get(index);
  }
  /**
   * <code>repeated .action.UserInfo user_infos = 1;</code>
   */
  public violet.gateway.common.proto_gen.action.UserInfoOrBuilder getUserInfosOrBuilder(
      int index) {
    return userInfos_.get(index);
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
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < userInfos_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, userInfos_.get(i));
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
    if (!(obj instanceof violet.gateway.common.proto_gen.http.SearchUserResponse)) {
      return super.equals(obj);
    }
    violet.gateway.common.proto_gen.http.SearchUserResponse other = (violet.gateway.common.proto_gen.http.SearchUserResponse) obj;

    boolean result = true;
    result = result && getUserInfosList()
        .equals(other.getUserInfosList());
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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.http.SearchUserResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(violet.gateway.common.proto_gen.http.SearchUserResponse prototype) {
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
   * Protobuf type {@code http.SearchUserResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:http.SearchUserResponse)
      violet.gateway.common.proto_gen.http.SearchUserResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return violet.gateway.common.proto_gen.http.Http.internal_static_http_SearchUserResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return violet.gateway.common.proto_gen.http.Http.internal_static_http_SearchUserResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              violet.gateway.common.proto_gen.http.SearchUserResponse.class, violet.gateway.common.proto_gen.http.SearchUserResponse.Builder.class);
    }

    // Construct using violet.gateway.common.proto_gen.http.SearchUserResponse.newBuilder()
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
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return violet.gateway.common.proto_gen.http.Http.internal_static_http_SearchUserResponse_descriptor;
    }

    public violet.gateway.common.proto_gen.http.SearchUserResponse getDefaultInstanceForType() {
      return violet.gateway.common.proto_gen.http.SearchUserResponse.getDefaultInstance();
    }

    public violet.gateway.common.proto_gen.http.SearchUserResponse build() {
      violet.gateway.common.proto_gen.http.SearchUserResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public violet.gateway.common.proto_gen.http.SearchUserResponse buildPartial() {
      violet.gateway.common.proto_gen.http.SearchUserResponse result = new violet.gateway.common.proto_gen.http.SearchUserResponse(this);
      int from_bitField0_ = bitField0_;
      if (userInfosBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          userInfos_ = java.util.Collections.unmodifiableList(userInfos_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.userInfos_ = userInfos_;
      } else {
        result.userInfos_ = userInfosBuilder_.build();
      }
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
      if (other instanceof violet.gateway.common.proto_gen.http.SearchUserResponse) {
        return mergeFrom((violet.gateway.common.proto_gen.http.SearchUserResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(violet.gateway.common.proto_gen.http.SearchUserResponse other) {
      if (other == violet.gateway.common.proto_gen.http.SearchUserResponse.getDefaultInstance()) return this;
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
      violet.gateway.common.proto_gen.http.SearchUserResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (violet.gateway.common.proto_gen.http.SearchUserResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<violet.gateway.common.proto_gen.action.UserInfo> userInfos_ =
      java.util.Collections.emptyList();
    private void ensureUserInfosIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        userInfos_ = new java.util.ArrayList<violet.gateway.common.proto_gen.action.UserInfo>(userInfos_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        violet.gateway.common.proto_gen.action.UserInfo, violet.gateway.common.proto_gen.action.UserInfo.Builder, violet.gateway.common.proto_gen.action.UserInfoOrBuilder> userInfosBuilder_;

    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public java.util.List<violet.gateway.common.proto_gen.action.UserInfo> getUserInfosList() {
      if (userInfosBuilder_ == null) {
        return java.util.Collections.unmodifiableList(userInfos_);
      } else {
        return userInfosBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public int getUserInfosCount() {
      if (userInfosBuilder_ == null) {
        return userInfos_.size();
      } else {
        return userInfosBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.UserInfo getUserInfos(int index) {
      if (userInfosBuilder_ == null) {
        return userInfos_.get(index);
      } else {
        return userInfosBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder setUserInfos(
        int index, violet.gateway.common.proto_gen.action.UserInfo value) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder setUserInfos(
        int index, violet.gateway.common.proto_gen.action.UserInfo.Builder builderForValue) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder addUserInfos(violet.gateway.common.proto_gen.action.UserInfo value) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder addUserInfos(
        int index, violet.gateway.common.proto_gen.action.UserInfo value) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder addUserInfos(
        violet.gateway.common.proto_gen.action.UserInfo.Builder builderForValue) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder addUserInfos(
        int index, violet.gateway.common.proto_gen.action.UserInfo.Builder builderForValue) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public Builder addAllUserInfos(
        java.lang.Iterable<? extends violet.gateway.common.proto_gen.action.UserInfo> values) {
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
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
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.UserInfo.Builder getUserInfosBuilder(
        int index) {
      return getUserInfosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.UserInfoOrBuilder getUserInfosOrBuilder(
        int index) {
      if (userInfosBuilder_ == null) {
        return userInfos_.get(index);  } else {
        return userInfosBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public java.util.List<? extends violet.gateway.common.proto_gen.action.UserInfoOrBuilder> 
         getUserInfosOrBuilderList() {
      if (userInfosBuilder_ != null) {
        return userInfosBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(userInfos_);
      }
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.UserInfo.Builder addUserInfosBuilder() {
      return getUserInfosFieldBuilder().addBuilder(
          violet.gateway.common.proto_gen.action.UserInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.UserInfo.Builder addUserInfosBuilder(
        int index) {
      return getUserInfosFieldBuilder().addBuilder(
          index, violet.gateway.common.proto_gen.action.UserInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .action.UserInfo user_infos = 1;</code>
     */
    public java.util.List<violet.gateway.common.proto_gen.action.UserInfo.Builder> 
         getUserInfosBuilderList() {
      return getUserInfosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        violet.gateway.common.proto_gen.action.UserInfo, violet.gateway.common.proto_gen.action.UserInfo.Builder, violet.gateway.common.proto_gen.action.UserInfoOrBuilder> 
        getUserInfosFieldBuilder() {
      if (userInfosBuilder_ == null) {
        userInfosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            violet.gateway.common.proto_gen.action.UserInfo, violet.gateway.common.proto_gen.action.UserInfo.Builder, violet.gateway.common.proto_gen.action.UserInfoOrBuilder>(
                userInfos_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        userInfos_ = null;
      }
      return userInfosBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:http.SearchUserResponse)
  }

  // @@protoc_insertion_point(class_scope:http.SearchUserResponse)
  private static final violet.gateway.common.proto_gen.http.SearchUserResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.http.SearchUserResponse();
  }

  public static violet.gateway.common.proto_gen.http.SearchUserResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchUserResponse>
      PARSER = new com.google.protobuf.AbstractParser<SearchUserResponse>() {
    public SearchUserResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SearchUserResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SearchUserResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchUserResponse> getParserForType() {
    return PARSER;
  }

  public violet.gateway.common.proto_gen.http.SearchUserResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

