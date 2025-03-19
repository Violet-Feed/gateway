// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/action.proto

package violet.gateway.common.proto_gen.action;

/**
 * Protobuf type {@code action.GetFollowListRequest}
 */
public  final class GetFollowListRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:action.GetFollowListRequest)
    GetFollowListRequestOrBuilder {
  // Use GetFollowListRequest.newBuilder() to construct.
  private GetFollowListRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetFollowListRequest() {
    userId_ = 0L;
    minTime_ = 0L;
    maxTime_ = 0L;
    count_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetFollowListRequest(
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
          case 8: {

            userId_ = input.readInt64();
            break;
          }
          case 16: {

            minTime_ = input.readInt64();
            break;
          }
          case 24: {

            maxTime_ = input.readInt64();
            break;
          }
          case 32: {

            count_ = input.readInt64();
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return violet.gateway.common.proto_gen.action.Action.internal_static_action_GetFollowListRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return violet.gateway.common.proto_gen.action.Action.internal_static_action_GetFollowListRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            violet.gateway.common.proto_gen.action.GetFollowListRequest.class, violet.gateway.common.proto_gen.action.GetFollowListRequest.Builder.class);
  }

  public static final int USER_ID_FIELD_NUMBER = 1;
  private long userId_;
  /**
   * <code>int64 user_id = 1;</code>
   */
  public long getUserId() {
    return userId_;
  }

  public static final int MIN_TIME_FIELD_NUMBER = 2;
  private long minTime_;
  /**
   * <code>int64 min_time = 2;</code>
   */
  public long getMinTime() {
    return minTime_;
  }

  public static final int MAX_TIME_FIELD_NUMBER = 3;
  private long maxTime_;
  /**
   * <code>int64 max_time = 3;</code>
   */
  public long getMaxTime() {
    return maxTime_;
  }

  public static final int COUNT_FIELD_NUMBER = 4;
  private long count_;
  /**
   * <code>int64 count = 4;</code>
   */
  public long getCount() {
    return count_;
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
    if (userId_ != 0L) {
      output.writeInt64(1, userId_);
    }
    if (minTime_ != 0L) {
      output.writeInt64(2, minTime_);
    }
    if (maxTime_ != 0L) {
      output.writeInt64(3, maxTime_);
    }
    if (count_ != 0L) {
      output.writeInt64(4, count_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, userId_);
    }
    if (minTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, minTime_);
    }
    if (maxTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, maxTime_);
    }
    if (count_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, count_);
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
    if (!(obj instanceof violet.gateway.common.proto_gen.action.GetFollowListRequest)) {
      return super.equals(obj);
    }
    violet.gateway.common.proto_gen.action.GetFollowListRequest other = (violet.gateway.common.proto_gen.action.GetFollowListRequest) obj;

    boolean result = true;
    result = result && (getUserId()
        == other.getUserId());
    result = result && (getMinTime()
        == other.getMinTime());
    result = result && (getMaxTime()
        == other.getMaxTime());
    result = result && (getCount()
        == other.getCount());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (37 * hash) + MIN_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMinTime());
    hash = (37 * hash) + MAX_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMaxTime());
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCount());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.GetFollowListRequest parseFrom(
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
  public static Builder newBuilder(violet.gateway.common.proto_gen.action.GetFollowListRequest prototype) {
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
   * Protobuf type {@code action.GetFollowListRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:action.GetFollowListRequest)
      violet.gateway.common.proto_gen.action.GetFollowListRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_GetFollowListRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_GetFollowListRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              violet.gateway.common.proto_gen.action.GetFollowListRequest.class, violet.gateway.common.proto_gen.action.GetFollowListRequest.Builder.class);
    }

    // Construct using violet.gateway.common.proto_gen.action.GetFollowListRequest.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      userId_ = 0L;

      minTime_ = 0L;

      maxTime_ = 0L;

      count_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_GetFollowListRequest_descriptor;
    }

    public violet.gateway.common.proto_gen.action.GetFollowListRequest getDefaultInstanceForType() {
      return violet.gateway.common.proto_gen.action.GetFollowListRequest.getDefaultInstance();
    }

    public violet.gateway.common.proto_gen.action.GetFollowListRequest build() {
      violet.gateway.common.proto_gen.action.GetFollowListRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public violet.gateway.common.proto_gen.action.GetFollowListRequest buildPartial() {
      violet.gateway.common.proto_gen.action.GetFollowListRequest result = new violet.gateway.common.proto_gen.action.GetFollowListRequest(this);
      result.userId_ = userId_;
      result.minTime_ = minTime_;
      result.maxTime_ = maxTime_;
      result.count_ = count_;
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
      if (other instanceof violet.gateway.common.proto_gen.action.GetFollowListRequest) {
        return mergeFrom((violet.gateway.common.proto_gen.action.GetFollowListRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(violet.gateway.common.proto_gen.action.GetFollowListRequest other) {
      if (other == violet.gateway.common.proto_gen.action.GetFollowListRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      if (other.getMinTime() != 0L) {
        setMinTime(other.getMinTime());
      }
      if (other.getMaxTime() != 0L) {
        setMaxTime(other.getMaxTime());
      }
      if (other.getCount() != 0L) {
        setCount(other.getCount());
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
      violet.gateway.common.proto_gen.action.GetFollowListRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (violet.gateway.common.proto_gen.action.GetFollowListRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long userId_ ;
    /**
     * <code>int64 user_id = 1;</code>
     */
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>int64 user_id = 1;</code>
     */
    public Builder setUserId(long value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 user_id = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0L;
      onChanged();
      return this;
    }

    private long minTime_ ;
    /**
     * <code>int64 min_time = 2;</code>
     */
    public long getMinTime() {
      return minTime_;
    }
    /**
     * <code>int64 min_time = 2;</code>
     */
    public Builder setMinTime(long value) {
      
      minTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 min_time = 2;</code>
     */
    public Builder clearMinTime() {
      
      minTime_ = 0L;
      onChanged();
      return this;
    }

    private long maxTime_ ;
    /**
     * <code>int64 max_time = 3;</code>
     */
    public long getMaxTime() {
      return maxTime_;
    }
    /**
     * <code>int64 max_time = 3;</code>
     */
    public Builder setMaxTime(long value) {
      
      maxTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 max_time = 3;</code>
     */
    public Builder clearMaxTime() {
      
      maxTime_ = 0L;
      onChanged();
      return this;
    }

    private long count_ ;
    /**
     * <code>int64 count = 4;</code>
     */
    public long getCount() {
      return count_;
    }
    /**
     * <code>int64 count = 4;</code>
     */
    public Builder setCount(long value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 count = 4;</code>
     */
    public Builder clearCount() {
      
      count_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:action.GetFollowListRequest)
  }

  // @@protoc_insertion_point(class_scope:action.GetFollowListRequest)
  private static final violet.gateway.common.proto_gen.action.GetFollowListRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.action.GetFollowListRequest();
  }

  public static violet.gateway.common.proto_gen.action.GetFollowListRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetFollowListRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetFollowListRequest>() {
    public GetFollowListRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetFollowListRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetFollowListRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetFollowListRequest> getParserForType() {
    return PARSER;
  }

  public violet.gateway.common.proto_gen.action.GetFollowListRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

