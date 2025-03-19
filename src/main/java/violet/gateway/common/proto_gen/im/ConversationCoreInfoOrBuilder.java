// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

public interface ConversationCoreInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.ConversationCoreInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 con_short_id = 1;</code>
   */
  long getConShortId();

  /**
   * <code>string con_id = 2;</code>
   */
  java.lang.String getConId();
  /**
   * <code>string con_id = 2;</code>
   */
  com.google.protobuf.ByteString
      getConIdBytes();

  /**
   * <code>int32 con_type = 3;</code>
   */
  int getConType();

  /**
   * <code>string name = 4;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 4;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string avatar_uri = 5;</code>
   */
  java.lang.String getAvatarUri();
  /**
   * <code>string avatar_uri = 5;</code>
   */
  com.google.protobuf.ByteString
      getAvatarUriBytes();

  /**
   * <code>string description = 6;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 6;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string notice = 7;</code>
   */
  java.lang.String getNotice();
  /**
   * <code>string notice = 7;</code>
   */
  com.google.protobuf.ByteString
      getNoticeBytes();

  /**
   * <code>int64 owner_id = 8;</code>
   */
  long getOwnerId();

  /**
   * <code>int64 create_time = 9;</code>
   */
  long getCreateTime();

  /**
   * <code>int64 modify_time = 10;</code>
   */
  long getModifyTime();

  /**
   * <code>int32 status = 11;</code>
   */
  int getStatus();

  /**
   * <code>string extra = 12;</code>
   */
  java.lang.String getExtra();
  /**
   * <code>string extra = 12;</code>
   */
  com.google.protobuf.ByteString
      getExtraBytes();

  /**
   * <code>int32 member_count = 13;</code>
   */
  int getMemberCount();
}
