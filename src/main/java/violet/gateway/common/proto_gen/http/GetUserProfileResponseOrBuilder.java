// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/http.proto

package violet.gateway.common.proto_gen.http;

public interface GetUserProfileResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:http.GetUserProfileResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.action.UserInfo user_info = 1;</code>
   */
  boolean hasUserInfo();
  /**
   * <code>.action.UserInfo user_info = 1;</code>
   */
  violet.gateway.common.proto_gen.action.UserInfo getUserInfo();
  /**
   * <code>.action.UserInfo user_info = 1;</code>
   */
  violet.gateway.common.proto_gen.action.UserInfoOrBuilder getUserInfoOrBuilder();

  /**
   * <code>int64 friend_count = 2;</code>
   */
  long getFriendCount();

  /**
   * <code>int64 following_count = 3;</code>
   */
  long getFollowingCount();

  /**
   * <code>int64 follower_count = 4;</code>
   */
  long getFollowerCount();
}
