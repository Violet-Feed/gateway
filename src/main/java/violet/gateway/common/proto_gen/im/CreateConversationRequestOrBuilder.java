// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

public interface CreateConversationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.CreateConversationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string con_id = 1;</code>
   */
  java.lang.String getConId();
  /**
   * <code>string con_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getConIdBytes();

  /**
   * <code>int32 con_type = 2;</code>
   */
  int getConType();

  /**
   * <code>string name = 3;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 3;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string avatar_uri = 4;</code>
   */
  java.lang.String getAvatarUri();
  /**
   * <code>string avatar_uri = 4;</code>
   */
  com.google.protobuf.ByteString
      getAvatarUriBytes();

  /**
   * <code>string description = 5;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 5;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string notice = 6;</code>
   */
  java.lang.String getNotice();
  /**
   * <code>string notice = 6;</code>
   */
  com.google.protobuf.ByteString
      getNoticeBytes();

  /**
   * <code>int64 owner_id = 7;</code>
   */
  long getOwnerId();

  /**
   * <code>repeated int64 members = 8;</code>
   */
  java.util.List<java.lang.Long> getMembersList();
  /**
   * <code>repeated int64 members = 8;</code>
   */
  int getMembersCount();
  /**
   * <code>repeated int64 members = 8;</code>
   */
  long getMembers(int index);

  /**
   * <code>string extra = 9;</code>
   */
  java.lang.String getExtra();
  /**
   * <code>string extra = 9;</code>
   */
  com.google.protobuf.ByteString
      getExtraBytes();
}
