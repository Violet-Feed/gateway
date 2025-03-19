// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

/**
 * Protobuf type {@code im.SendMessageResponse}
 */
public  final class SendMessageResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.SendMessageResponse)
    SendMessageResponseOrBuilder {
  // Use SendMessageResponse.newBuilder() to construct.
  private SendMessageResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SendMessageResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SendMessageResponse(
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
          case 2042: {
            violet.gateway.common.proto_gen.im.BaseResp.Builder subBuilder = null;
            if (baseResp_ != null) {
              subBuilder = baseResp_.toBuilder();
            }
            baseResp_ = input.readMessage(violet.gateway.common.proto_gen.im.BaseResp.parser(), extensionRegistry);
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return violet.gateway.common.proto_gen.im.Im.internal_static_im_SendMessageResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return violet.gateway.common.proto_gen.im.Im.internal_static_im_SendMessageResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            violet.gateway.common.proto_gen.im.SendMessageResponse.class, violet.gateway.common.proto_gen.im.SendMessageResponse.Builder.class);
  }

  public static final int BASERESP_FIELD_NUMBER = 255;
  private violet.gateway.common.proto_gen.im.BaseResp baseResp_;
  /**
   * <code>.im.BaseResp baseResp = 255;</code>
   */
  public boolean hasBaseResp() {
    return baseResp_ != null;
  }
  /**
   * <code>.im.BaseResp baseResp = 255;</code>
   */
  public violet.gateway.common.proto_gen.im.BaseResp getBaseResp() {
    return baseResp_ == null ? violet.gateway.common.proto_gen.im.BaseResp.getDefaultInstance() : baseResp_;
  }
  /**
   * <code>.im.BaseResp baseResp = 255;</code>
   */
  public violet.gateway.common.proto_gen.im.BaseRespOrBuilder getBaseRespOrBuilder() {
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
    if (baseResp_ != null) {
      output.writeMessage(255, getBaseResp());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
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
    if (!(obj instanceof violet.gateway.common.proto_gen.im.SendMessageResponse)) {
      return super.equals(obj);
    }
    violet.gateway.common.proto_gen.im.SendMessageResponse other = (violet.gateway.common.proto_gen.im.SendMessageResponse) obj;

    boolean result = true;
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
    if (hasBaseResp()) {
      hash = (37 * hash) + BASERESP_FIELD_NUMBER;
      hash = (53 * hash) + getBaseResp().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static violet.gateway.common.proto_gen.im.SendMessageResponse parseFrom(
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
  public static Builder newBuilder(violet.gateway.common.proto_gen.im.SendMessageResponse prototype) {
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
   * Protobuf type {@code im.SendMessageResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.SendMessageResponse)
      violet.gateway.common.proto_gen.im.SendMessageResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_SendMessageResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_SendMessageResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              violet.gateway.common.proto_gen.im.SendMessageResponse.class, violet.gateway.common.proto_gen.im.SendMessageResponse.Builder.class);
    }

    // Construct using violet.gateway.common.proto_gen.im.SendMessageResponse.newBuilder()
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
      return violet.gateway.common.proto_gen.im.Im.internal_static_im_SendMessageResponse_descriptor;
    }

    public violet.gateway.common.proto_gen.im.SendMessageResponse getDefaultInstanceForType() {
      return violet.gateway.common.proto_gen.im.SendMessageResponse.getDefaultInstance();
    }

    public violet.gateway.common.proto_gen.im.SendMessageResponse build() {
      violet.gateway.common.proto_gen.im.SendMessageResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public violet.gateway.common.proto_gen.im.SendMessageResponse buildPartial() {
      violet.gateway.common.proto_gen.im.SendMessageResponse result = new violet.gateway.common.proto_gen.im.SendMessageResponse(this);
      if (baseRespBuilder_ == null) {
        result.baseResp_ = baseResp_;
      } else {
        result.baseResp_ = baseRespBuilder_.build();
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
      if (other instanceof violet.gateway.common.proto_gen.im.SendMessageResponse) {
        return mergeFrom((violet.gateway.common.proto_gen.im.SendMessageResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(violet.gateway.common.proto_gen.im.SendMessageResponse other) {
      if (other == violet.gateway.common.proto_gen.im.SendMessageResponse.getDefaultInstance()) return this;
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
      violet.gateway.common.proto_gen.im.SendMessageResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (violet.gateway.common.proto_gen.im.SendMessageResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private violet.gateway.common.proto_gen.im.BaseResp baseResp_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        violet.gateway.common.proto_gen.im.BaseResp, violet.gateway.common.proto_gen.im.BaseResp.Builder, violet.gateway.common.proto_gen.im.BaseRespOrBuilder> baseRespBuilder_;
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public boolean hasBaseResp() {
      return baseRespBuilder_ != null || baseResp_ != null;
    }
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public violet.gateway.common.proto_gen.im.BaseResp getBaseResp() {
      if (baseRespBuilder_ == null) {
        return baseResp_ == null ? violet.gateway.common.proto_gen.im.BaseResp.getDefaultInstance() : baseResp_;
      } else {
        return baseRespBuilder_.getMessage();
      }
    }
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public Builder setBaseResp(violet.gateway.common.proto_gen.im.BaseResp value) {
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
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public Builder setBaseResp(
        violet.gateway.common.proto_gen.im.BaseResp.Builder builderForValue) {
      if (baseRespBuilder_ == null) {
        baseResp_ = builderForValue.build();
        onChanged();
      } else {
        baseRespBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public Builder mergeBaseResp(violet.gateway.common.proto_gen.im.BaseResp value) {
      if (baseRespBuilder_ == null) {
        if (baseResp_ != null) {
          baseResp_ =
            violet.gateway.common.proto_gen.im.BaseResp.newBuilder(baseResp_).mergeFrom(value).buildPartial();
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
     * <code>.im.BaseResp baseResp = 255;</code>
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
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public violet.gateway.common.proto_gen.im.BaseResp.Builder getBaseRespBuilder() {
      
      onChanged();
      return getBaseRespFieldBuilder().getBuilder();
    }
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    public violet.gateway.common.proto_gen.im.BaseRespOrBuilder getBaseRespOrBuilder() {
      if (baseRespBuilder_ != null) {
        return baseRespBuilder_.getMessageOrBuilder();
      } else {
        return baseResp_ == null ?
            violet.gateway.common.proto_gen.im.BaseResp.getDefaultInstance() : baseResp_;
      }
    }
    /**
     * <code>.im.BaseResp baseResp = 255;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        violet.gateway.common.proto_gen.im.BaseResp, violet.gateway.common.proto_gen.im.BaseResp.Builder, violet.gateway.common.proto_gen.im.BaseRespOrBuilder> 
        getBaseRespFieldBuilder() {
      if (baseRespBuilder_ == null) {
        baseRespBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            violet.gateway.common.proto_gen.im.BaseResp, violet.gateway.common.proto_gen.im.BaseResp.Builder, violet.gateway.common.proto_gen.im.BaseRespOrBuilder>(
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


    // @@protoc_insertion_point(builder_scope:im.SendMessageResponse)
  }

  // @@protoc_insertion_point(class_scope:im.SendMessageResponse)
  private static final violet.gateway.common.proto_gen.im.SendMessageResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new violet.gateway.common.proto_gen.im.SendMessageResponse();
  }

  public static violet.gateway.common.proto_gen.im.SendMessageResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SendMessageResponse>
      PARSER = new com.google.protobuf.AbstractParser<SendMessageResponse>() {
    public SendMessageResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SendMessageResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SendMessageResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SendMessageResponse> getParserForType() {
    return PARSER;
  }

  public violet.gateway.common.proto_gen.im.SendMessageResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

