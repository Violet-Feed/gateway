// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/action.proto

package violet.gateway.common.proto_gen.action;

/**
 * Protobuf type {@code action.BaseResp}
 */
public  final class BaseResp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:action.BaseResp)
    BaseRespOrBuilder {
  // Use BaseResp.newBuilder() to construct.
  private BaseResp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BaseResp() {
    statusCode_ = 0;
    statusMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private BaseResp(
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
            int rawValue = input.readEnum();

            statusCode_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            statusMessage_ = s;
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
    return violet.gateway.common.proto_gen.action.Action.internal_static_action_BaseResp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return violet.gateway.common.proto_gen.action.Action.internal_static_action_BaseResp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            violet.gateway.common.proto_gen.action.BaseResp.class, violet.gateway.common.proto_gen.action.BaseResp.Builder.class);
  }

  public static final int STATUSCODE_FIELD_NUMBER = 1;
  private int statusCode_;
  /**
   * <code>.action.StatusCode StatusCode = 1;</code>
   */
  public int getStatusCodeValue() {
    return statusCode_;
  }
  /**
   * <code>.action.StatusCode StatusCode = 1;</code>
   */
  public violet.gateway.common.proto_gen.action.StatusCode getStatusCode() {
    violet.gateway.common.proto_gen.action.StatusCode result = violet.gateway.common.proto_gen.action.StatusCode.valueOf(statusCode_);
    return result == null ? violet.gateway.common.proto_gen.action.StatusCode.UNRECOGNIZED : result;
  }

  public static final int STATUSMESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object statusMessage_;
  /**
   * <code>string StatusMessage = 2;</code>
   */
  public java.lang.String getStatusMessage() {
    java.lang.Object ref = statusMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      statusMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string StatusMessage = 2;</code>
   */
  public com.google.protobuf.ByteString
      getStatusMessageBytes() {
    java.lang.Object ref = statusMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      statusMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (statusCode_ != violet.gateway.common.proto_gen.action.StatusCode.StatusCode_Not_Use.getNumber()) {
      output.writeEnum(1, statusCode_);
    }
    if (!getStatusMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, statusMessage_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (statusCode_ != violet.gateway.common.proto_gen.action.StatusCode.StatusCode_Not_Use.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, statusCode_);
    }
    if (!getStatusMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, statusMessage_);
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
    if (!(obj instanceof violet.gateway.common.proto_gen.action.BaseResp)) {
      return super.equals(obj);
    }
    violet.gateway.common.proto_gen.action.BaseResp other = (violet.gateway.common.proto_gen.action.BaseResp) obj;

    boolean result = true;
    result = result && statusCode_ == other.statusCode_;
    result = result && getStatusMessage()
        .equals(other.getStatusMessage());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUSCODE_FIELD_NUMBER;
    hash = (53 * hash) + statusCode_;
    hash = (37 * hash) + STATUSMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getStatusMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.action.BaseResp parseFrom(
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
  public static Builder newBuilder(violet.gateway.common.proto_gen.action.BaseResp prototype) {
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
   * Protobuf type {@code action.BaseResp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:action.BaseResp)
      violet.gateway.common.proto_gen.action.BaseRespOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_BaseResp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_BaseResp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              violet.gateway.common.proto_gen.action.BaseResp.class, violet.gateway.common.proto_gen.action.BaseResp.Builder.class);
    }

    // Construct using violet.gateway.common.proto_gen.action.BaseResp.newBuilder()
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
      statusCode_ = 0;

      statusMessage_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return violet.gateway.common.proto_gen.action.Action.internal_static_action_BaseResp_descriptor;
    }

    public violet.gateway.common.proto_gen.action.BaseResp getDefaultInstanceForType() {
      return violet.gateway.common.proto_gen.action.BaseResp.getDefaultInstance();
    }

    public violet.gateway.common.proto_gen.action.BaseResp build() {
      violet.gateway.common.proto_gen.action.BaseResp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public violet.gateway.common.proto_gen.action.BaseResp buildPartial() {
      violet.gateway.common.proto_gen.action.BaseResp result = new violet.gateway.common.proto_gen.action.BaseResp(this);
      result.statusCode_ = statusCode_;
      result.statusMessage_ = statusMessage_;
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
      if (other instanceof violet.gateway.common.proto_gen.action.BaseResp) {
        return mergeFrom((violet.gateway.common.proto_gen.action.BaseResp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(violet.gateway.common.proto_gen.action.BaseResp other) {
      if (other == violet.gateway.common.proto_gen.action.BaseResp.getDefaultInstance()) return this;
      if (other.statusCode_ != 0) {
        setStatusCodeValue(other.getStatusCodeValue());
      }
      if (!other.getStatusMessage().isEmpty()) {
        statusMessage_ = other.statusMessage_;
        onChanged();
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
      violet.gateway.common.proto_gen.action.BaseResp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (violet.gateway.common.proto_gen.action.BaseResp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int statusCode_ = 0;
    /**
     * <code>.action.StatusCode StatusCode = 1;</code>
     */
    public int getStatusCodeValue() {
      return statusCode_;
    }
    /**
     * <code>.action.StatusCode StatusCode = 1;</code>
     */
    public Builder setStatusCodeValue(int value) {
      statusCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.action.StatusCode StatusCode = 1;</code>
     */
    public violet.gateway.common.proto_gen.action.StatusCode getStatusCode() {
      violet.gateway.common.proto_gen.action.StatusCode result = violet.gateway.common.proto_gen.action.StatusCode.valueOf(statusCode_);
      return result == null ? violet.gateway.common.proto_gen.action.StatusCode.UNRECOGNIZED : result;
    }
    /**
     * <code>.action.StatusCode StatusCode = 1;</code>
     */
    public Builder setStatusCode(violet.gateway.common.proto_gen.action.StatusCode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      statusCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.action.StatusCode StatusCode = 1;</code>
     */
    public Builder clearStatusCode() {
      
      statusCode_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object statusMessage_ = "";
    /**
     * <code>string StatusMessage = 2;</code>
     */
    public java.lang.String getStatusMessage() {
      java.lang.Object ref = statusMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        statusMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string StatusMessage = 2;</code>
     */
    public com.google.protobuf.ByteString
        getStatusMessageBytes() {
      java.lang.Object ref = statusMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        statusMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string StatusMessage = 2;</code>
     */
    public Builder setStatusMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      statusMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string StatusMessage = 2;</code>
     */
    public Builder clearStatusMessage() {
      
      statusMessage_ = getDefaultInstance().getStatusMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string StatusMessage = 2;</code>
     */
    public Builder setStatusMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      statusMessage_ = value;
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


    // @@protoc_insertion_point(builder_scope:action.BaseResp)
  }

  // @@protoc_insertion_point(class_scope:action.BaseResp)
  private static final violet.gateway.common.proto_gen.action.BaseResp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.action.BaseResp();
  }

  public static violet.gateway.common.proto_gen.action.BaseResp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BaseResp>
      PARSER = new com.google.protobuf.AbstractParser<BaseResp>() {
    public BaseResp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BaseResp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BaseResp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BaseResp> getParserForType() {
    return PARSER;
  }

  public violet.gateway.common.proto_gen.action.BaseResp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

