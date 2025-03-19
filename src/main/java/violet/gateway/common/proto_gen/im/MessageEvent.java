// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

/**
 * Protobuf type {@code im.MessageEvent}
 */
public  final class MessageEvent extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.MessageEvent)
    MessageEventOrBuilder {
  // Use MessageEvent.newBuilder() to construct.
  private MessageEvent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageEvent() {
    conIndex_ = 0L;
    stored_ = false;
    userConIndex_ = 0L;
    preUserConIndex_ = 0L;
    badgeCount_ = 0L;
    userCmdIndex_ = 0L;
    retryCount_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MessageEvent(
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
            violet.gateway.common.proto_gen.im.MessageBody.Builder subBuilder = null;
            if (msgBody_ != null) {
              subBuilder = msgBody_.toBuilder();
            }
            msgBody_ = input.readMessage(violet.gateway.common.proto_gen.im.MessageBody.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(msgBody_);
              msgBody_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            conIndex_ = input.readInt64();
            break;
          }
          case 24: {

            stored_ = input.readBool();
            break;
          }
          case 32: {

            userConIndex_ = input.readInt64();
            break;
          }
          case 40: {

            preUserConIndex_ = input.readInt64();
            break;
          }
          case 48: {

            badgeCount_ = input.readInt64();
            break;
          }
          case 56: {

            userCmdIndex_ = input.readInt64();
            break;
          }
          case 64: {

            retryCount_ = input.readInt32();
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
    return violet.gateway.common.proto_gen.im.Im.internal_static_im_MessageEvent_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return violet.gateway.common.proto_gen.im.Im.internal_static_im_MessageEvent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            violet.gateway.common.proto_gen.im.MessageEvent.class, violet.gateway.common.proto_gen.im.MessageEvent.Builder.class);
  }

  public static final int MSG_BODY_FIELD_NUMBER = 1;
  private violet.gateway.common.proto_gen.im.MessageBody msgBody_;
  /**
   * <code>.im.MessageBody msg_body = 1;</code>
   */
  public boolean hasMsgBody() {
    return msgBody_ != null;
  }
  /**
   * <code>.im.MessageBody msg_body = 1;</code>
   */
  public violet.gateway.common.proto_gen.im.MessageBody getMsgBody() {
    return msgBody_ == null ? violet.gateway.common.proto_gen.im.MessageBody.getDefaultInstance() : msgBody_;
  }
  /**
   * <code>.im.MessageBody msg_body = 1;</code>
   */
  public violet.gateway.common.proto_gen.im.MessageBodyOrBuilder getMsgBodyOrBuilder() {
    return getMsgBody();
  }

  public static final int CON_INDEX_FIELD_NUMBER = 2;
  private long conIndex_;
  /**
   * <code>int64 con_index = 2;</code>
   */
  public long getConIndex() {
    return conIndex_;
  }

  public static final int STORED_FIELD_NUMBER = 3;
  private boolean stored_;
  /**
   * <code>bool stored = 3;</code>
   */
  public boolean getStored() {
    return stored_;
  }

  public static final int USER_CON_INDEX_FIELD_NUMBER = 4;
  private long userConIndex_;
  /**
   * <code>int64 user_con_index = 4;</code>
   */
  public long getUserConIndex() {
    return userConIndex_;
  }

  public static final int PRE_USER_CON_INDEX_FIELD_NUMBER = 5;
  private long preUserConIndex_;
  /**
   * <code>int64 pre_user_con_index = 5;</code>
   */
  public long getPreUserConIndex() {
    return preUserConIndex_;
  }

  public static final int BADGE_COUNT_FIELD_NUMBER = 6;
  private long badgeCount_;
  /**
   * <code>int64 badge_count = 6;</code>
   */
  public long getBadgeCount() {
    return badgeCount_;
  }

  public static final int USER_CMD_INDEX_FIELD_NUMBER = 7;
  private long userCmdIndex_;
  /**
   * <code>int64 user_cmd_index = 7;</code>
   */
  public long getUserCmdIndex() {
    return userCmdIndex_;
  }

  public static final int RETRY_COUNT_FIELD_NUMBER = 8;
  private int retryCount_;
  /**
   * <code>int32 retry_count = 8;</code>
   */
  public int getRetryCount() {
    return retryCount_;
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
    if (msgBody_ != null) {
      output.writeMessage(1, getMsgBody());
    }
    if (conIndex_ != 0L) {
      output.writeInt64(2, conIndex_);
    }
    if (stored_ != false) {
      output.writeBool(3, stored_);
    }
    if (userConIndex_ != 0L) {
      output.writeInt64(4, userConIndex_);
    }
    if (preUserConIndex_ != 0L) {
      output.writeInt64(5, preUserConIndex_);
    }
    if (badgeCount_ != 0L) {
      output.writeInt64(6, badgeCount_);
    }
    if (userCmdIndex_ != 0L) {
      output.writeInt64(7, userCmdIndex_);
    }
    if (retryCount_ != 0) {
      output.writeInt32(8, retryCount_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (msgBody_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getMsgBody());
    }
    if (conIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, conIndex_);
    }
    if (stored_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, stored_);
    }
    if (userConIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, userConIndex_);
    }
    if (preUserConIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, preUserConIndex_);
    }
    if (badgeCount_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, badgeCount_);
    }
    if (userCmdIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(7, userCmdIndex_);
    }
    if (retryCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, retryCount_);
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
    if (!(obj instanceof violet.gateway.common.proto_gen.im.MessageEvent)) {
      return super.equals(obj);
    }
    violet.gateway.common.proto_gen.im.MessageEvent other = (violet.gateway.common.proto_gen.im.MessageEvent) obj;

    boolean result = true;
    result = result && (hasMsgBody() == other.hasMsgBody());
    if (hasMsgBody()) {
      result = result && getMsgBody()
          .equals(other.getMsgBody());
    }
    result = result && (getConIndex()
        == other.getConIndex());
    result = result && (getStored()
        == other.getStored());
    result = result && (getUserConIndex()
        == other.getUserConIndex());
    result = result && (getPreUserConIndex()
        == other.getPreUserConIndex());
    result = result && (getBadgeCount()
        == other.getBadgeCount());
    result = result && (getUserCmdIndex()
        == other.getUserCmdIndex());
    result = result && (getRetryCount()
        == other.getRetryCount());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasMsgBody()) {
      hash = (37 * hash) + MSG_BODY_FIELD_NUMBER;
      hash = (53 * hash) + getMsgBody().hashCode();
    }
    hash = (37 * hash) + CON_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getConIndex());
    hash = (37 * hash) + STORED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getStored());
    hash = (37 * hash) + USER_CON_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserConIndex());
    hash = (37 * hash) + PRE_USER_CON_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPreUserConIndex());
    hash = (37 * hash) + BADGE_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBadgeCount());
    hash = (37 * hash) + USER_CMD_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserCmdIndex());
    hash = (37 * hash) + RETRY_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getRetryCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.MessageEvent parseFrom(
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
  public static Builder newBuilder(violet.gateway.common.proto_gen.im.MessageEvent prototype) {
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
   * Protobuf type {@code im.MessageEvent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.MessageEvent)
      violet.gateway.common.proto_gen.im.MessageEventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_MessageEvent_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_MessageEvent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              violet.gateway.common.proto_gen.im.MessageEvent.class, violet.gateway.common.proto_gen.im.MessageEvent.Builder.class);
    }

    // Construct using violet.gateway.common.proto_gen.im.MessageEvent.newBuilder()
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
      if (msgBodyBuilder_ == null) {
        msgBody_ = null;
      } else {
        msgBody_ = null;
        msgBodyBuilder_ = null;
      }
      conIndex_ = 0L;

      stored_ = false;

      userConIndex_ = 0L;

      preUserConIndex_ = 0L;

      badgeCount_ = 0L;

      userCmdIndex_ = 0L;

      retryCount_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_MessageEvent_descriptor;
    }

    public violet.gateway.common.proto_gen.im.MessageEvent getDefaultInstanceForType() {
      return violet.gateway.common.proto_gen.im.MessageEvent.getDefaultInstance();
    }

    public violet.gateway.common.proto_gen.im.MessageEvent build() {
      violet.gateway.common.proto_gen.im.MessageEvent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public violet.gateway.common.proto_gen.im.MessageEvent buildPartial() {
      violet.gateway.common.proto_gen.im.MessageEvent result = new violet.gateway.common.proto_gen.im.MessageEvent(this);
      if (msgBodyBuilder_ == null) {
        result.msgBody_ = msgBody_;
      } else {
        result.msgBody_ = msgBodyBuilder_.build();
      }
      result.conIndex_ = conIndex_;
      result.stored_ = stored_;
      result.userConIndex_ = userConIndex_;
      result.preUserConIndex_ = preUserConIndex_;
      result.badgeCount_ = badgeCount_;
      result.userCmdIndex_ = userCmdIndex_;
      result.retryCount_ = retryCount_;
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
      if (other instanceof violet.gateway.common.proto_gen.im.MessageEvent) {
        return mergeFrom((violet.gateway.common.proto_gen.im.MessageEvent)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(violet.gateway.common.proto_gen.im.MessageEvent other) {
      if (other == violet.gateway.common.proto_gen.im.MessageEvent.getDefaultInstance()) return this;
      if (other.hasMsgBody()) {
        mergeMsgBody(other.getMsgBody());
      }
      if (other.getConIndex() != 0L) {
        setConIndex(other.getConIndex());
      }
      if (other.getStored() != false) {
        setStored(other.getStored());
      }
      if (other.getUserConIndex() != 0L) {
        setUserConIndex(other.getUserConIndex());
      }
      if (other.getPreUserConIndex() != 0L) {
        setPreUserConIndex(other.getPreUserConIndex());
      }
      if (other.getBadgeCount() != 0L) {
        setBadgeCount(other.getBadgeCount());
      }
      if (other.getUserCmdIndex() != 0L) {
        setUserCmdIndex(other.getUserCmdIndex());
      }
      if (other.getRetryCount() != 0) {
        setRetryCount(other.getRetryCount());
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
      violet.gateway.common.proto_gen.im.MessageEvent parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (violet.gateway.common.proto_gen.im.MessageEvent) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private violet.gateway.common.proto_gen.im.MessageBody msgBody_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        violet.gateway.common.proto_gen.im.MessageBody, violet.gateway.common.proto_gen.im.MessageBody.Builder, violet.gateway.common.proto_gen.im.MessageBodyOrBuilder> msgBodyBuilder_;
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public boolean hasMsgBody() {
      return msgBodyBuilder_ != null || msgBody_ != null;
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public violet.gateway.common.proto_gen.im.MessageBody getMsgBody() {
      if (msgBodyBuilder_ == null) {
        return msgBody_ == null ? violet.gateway.common.proto_gen.im.MessageBody.getDefaultInstance() : msgBody_;
      } else {
        return msgBodyBuilder_.getMessage();
      }
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public Builder setMsgBody(violet.gateway.common.proto_gen.im.MessageBody value) {
      if (msgBodyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        msgBody_ = value;
        onChanged();
      } else {
        msgBodyBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public Builder setMsgBody(
        violet.gateway.common.proto_gen.im.MessageBody.Builder builderForValue) {
      if (msgBodyBuilder_ == null) {
        msgBody_ = builderForValue.build();
        onChanged();
      } else {
        msgBodyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public Builder mergeMsgBody(violet.gateway.common.proto_gen.im.MessageBody value) {
      if (msgBodyBuilder_ == null) {
        if (msgBody_ != null) {
          msgBody_ =
            violet.gateway.common.proto_gen.im.MessageBody.newBuilder(msgBody_).mergeFrom(value).buildPartial();
        } else {
          msgBody_ = value;
        }
        onChanged();
      } else {
        msgBodyBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public Builder clearMsgBody() {
      if (msgBodyBuilder_ == null) {
        msgBody_ = null;
        onChanged();
      } else {
        msgBody_ = null;
        msgBodyBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public violet.gateway.common.proto_gen.im.MessageBody.Builder getMsgBodyBuilder() {
      
      onChanged();
      return getMsgBodyFieldBuilder().getBuilder();
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    public violet.gateway.common.proto_gen.im.MessageBodyOrBuilder getMsgBodyOrBuilder() {
      if (msgBodyBuilder_ != null) {
        return msgBodyBuilder_.getMessageOrBuilder();
      } else {
        return msgBody_ == null ?
            violet.gateway.common.proto_gen.im.MessageBody.getDefaultInstance() : msgBody_;
      }
    }
    /**
     * <code>.im.MessageBody msg_body = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        violet.gateway.common.proto_gen.im.MessageBody, violet.gateway.common.proto_gen.im.MessageBody.Builder, violet.gateway.common.proto_gen.im.MessageBodyOrBuilder> 
        getMsgBodyFieldBuilder() {
      if (msgBodyBuilder_ == null) {
        msgBodyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            violet.gateway.common.proto_gen.im.MessageBody, violet.gateway.common.proto_gen.im.MessageBody.Builder, violet.gateway.common.proto_gen.im.MessageBodyOrBuilder>(
                getMsgBody(),
                getParentForChildren(),
                isClean());
        msgBody_ = null;
      }
      return msgBodyBuilder_;
    }

    private long conIndex_ ;
    /**
     * <code>int64 con_index = 2;</code>
     */
    public long getConIndex() {
      return conIndex_;
    }
    /**
     * <code>int64 con_index = 2;</code>
     */
    public Builder setConIndex(long value) {
      
      conIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 con_index = 2;</code>
     */
    public Builder clearConIndex() {
      
      conIndex_ = 0L;
      onChanged();
      return this;
    }

    private boolean stored_ ;
    /**
     * <code>bool stored = 3;</code>
     */
    public boolean getStored() {
      return stored_;
    }
    /**
     * <code>bool stored = 3;</code>
     */
    public Builder setStored(boolean value) {
      
      stored_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool stored = 3;</code>
     */
    public Builder clearStored() {
      
      stored_ = false;
      onChanged();
      return this;
    }

    private long userConIndex_ ;
    /**
     * <code>int64 user_con_index = 4;</code>
     */
    public long getUserConIndex() {
      return userConIndex_;
    }
    /**
     * <code>int64 user_con_index = 4;</code>
     */
    public Builder setUserConIndex(long value) {
      
      userConIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 user_con_index = 4;</code>
     */
    public Builder clearUserConIndex() {
      
      userConIndex_ = 0L;
      onChanged();
      return this;
    }

    private long preUserConIndex_ ;
    /**
     * <code>int64 pre_user_con_index = 5;</code>
     */
    public long getPreUserConIndex() {
      return preUserConIndex_;
    }
    /**
     * <code>int64 pre_user_con_index = 5;</code>
     */
    public Builder setPreUserConIndex(long value) {
      
      preUserConIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 pre_user_con_index = 5;</code>
     */
    public Builder clearPreUserConIndex() {
      
      preUserConIndex_ = 0L;
      onChanged();
      return this;
    }

    private long badgeCount_ ;
    /**
     * <code>int64 badge_count = 6;</code>
     */
    public long getBadgeCount() {
      return badgeCount_;
    }
    /**
     * <code>int64 badge_count = 6;</code>
     */
    public Builder setBadgeCount(long value) {
      
      badgeCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 badge_count = 6;</code>
     */
    public Builder clearBadgeCount() {
      
      badgeCount_ = 0L;
      onChanged();
      return this;
    }

    private long userCmdIndex_ ;
    /**
     * <code>int64 user_cmd_index = 7;</code>
     */
    public long getUserCmdIndex() {
      return userCmdIndex_;
    }
    /**
     * <code>int64 user_cmd_index = 7;</code>
     */
    public Builder setUserCmdIndex(long value) {
      
      userCmdIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 user_cmd_index = 7;</code>
     */
    public Builder clearUserCmdIndex() {
      
      userCmdIndex_ = 0L;
      onChanged();
      return this;
    }

    private int retryCount_ ;
    /**
     * <code>int32 retry_count = 8;</code>
     */
    public int getRetryCount() {
      return retryCount_;
    }
    /**
     * <code>int32 retry_count = 8;</code>
     */
    public Builder setRetryCount(int value) {
      
      retryCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 retry_count = 8;</code>
     */
    public Builder clearRetryCount() {
      
      retryCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:im.MessageEvent)
  }

  // @@protoc_insertion_point(class_scope:im.MessageEvent)
  private static final violet.gateway.common.proto_gen.im.MessageEvent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.im.MessageEvent();
  }

  public static violet.gateway.common.proto_gen.im.MessageEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageEvent>
      PARSER = new com.google.protobuf.AbstractParser<MessageEvent>() {
    public MessageEvent parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageEvent(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageEvent> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageEvent> getParserForType() {
    return PARSER;
  }

  public violet.gateway.common.proto_gen.im.MessageEvent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

