// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/im.proto

package violet.gateway.common.proto_gen.im;

public interface ConversationSettingInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.ConversationSettingInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 user_id = 1;</code>
   */
  long getUserId();

  /**
   * <code>int64 con_short_id = 2;</code>
   */
  long getConShortId();

  /**
   * <code>int32 con_type = 3;</code>
   */
  int getConType();

  /**
   * <code>int64 min_index = 4;</code>
   */
  long getMinIndex();

  /**
   * <code>int64 top_time_stamp = 5;</code>
   */
  long getTopTimeStamp();

  /**
   * <code>int32 push_status = 6;</code>
   */
  int getPushStatus();

  /**
   * <code>int64 modify_time = 7;</code>
   */
  long getModifyTime();

  /**
   * <code>string extra = 8;</code>
   */
  java.lang.String getExtra();
  /**
   * <code>string extra = 8;</code>
   */
  com.google.protobuf.ByteString
      getExtraBytes();

  /**
   * <code>int64 read_index_end = 9;</code>
   */
  long getReadIndexEnd();

  /**
   * <code>int64 read_badge_count = 10;</code>
   */
  long getReadBadgeCount();
}
