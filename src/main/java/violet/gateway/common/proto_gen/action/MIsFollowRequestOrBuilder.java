// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/action.proto

package violet.gateway.common.proto_gen.action;

public interface MIsFollowRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:action.MIsFollowRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 from_user_id = 1;</code>
   */
  long getFromUserId();

  /**
   * <code>repeated int64 to_user_ids = 2;</code>
   */
  java.util.List<java.lang.Long> getToUserIdsList();
  /**
   * <code>repeated int64 to_user_ids = 2;</code>
   */
  int getToUserIdsCount();
  /**
   * <code>repeated int64 to_user_ids = 2;</code>
   */
  long getToUserIds(int index);
}
