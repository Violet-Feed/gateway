// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/action.proto

package violet.gateway.common.proto_gen.action;

public final class Action {
    private Action() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_LoginRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_LoginRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_LoginResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_LoginResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_RegisterRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_RegisterRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_RegisterResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_RegisterResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_UserInfo_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_UserInfo_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_GetUserInfosRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_GetUserInfosRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_GetUserInfosResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_GetUserInfosResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_SearchUsersRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_SearchUsersRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_SearchUsersResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_SearchUsersResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_FollowRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_FollowRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_FollowResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_FollowResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MIsFollowRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MIsFollowRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MIsFollowResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MIsFollowResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MIsFollowResponse_IsFollowingEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MIsFollowResponse_IsFollowingEntry_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MIsFollowResponse_IsFollowerEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MIsFollowResponse_IsFollowerEntry_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_GetFollowListRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_GetFollowListRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_GetFollowListResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_GetFollowListResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MGetFollowCountRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MGetFollowCountRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MGetFollowCountResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MGetFollowCountResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MGetFollowCountResponse_FollowingCountEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MGetFollowCountResponse_FollowingCountEntry_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MGetFollowCountResponse_FollowerCountEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MGetFollowCountResponse_FollowerCountEntry_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_action_MGetFollowCountResponse_FriendCountEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_action_MGetFollowCountResponse_FriendCountEntry_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\022proto/action.proto\022\006action\032\022proto/comm" +
                        "on.proto\"2\n\014LoginRequest\022\020\n\010username\030\001 \001" +
                        "(\t\022\020\n\010password\030\002 \001(\t\"E\n\rLoginResponse\022\017\n" +
                        "\007user_id\030\001 \001(\003\022#\n\010baseResp\030\377\001 \001(\0132\020.comm" +
                        "on.BaseResp\"O\n\017RegisterRequest\022\020\n\010userna" +
                        "me\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\022\030\n\020confirm_pa" +
                        "ssword\030\003 \001(\t\"7\n\020RegisterResponse\022#\n\010base" +
                        "Resp\030\377\001 \001(\0132\020.common.BaseResp\"=\n\010UserInf" +
                        "o\022\017\n\007user_id\030\001 \001(\003\022\020\n\010username\030\002 \001(\t\022\016\n\006" +
                        "avatar\030\003 \001(\t\"\'\n\023GetUserInfosRequest\022\020\n\010u",
                "ser_ids\030\001 \003(\003\"a\n\024GetUserInfosResponse\022$\n" +
                        "\nuser_infos\030\001 \003(\0132\020.action.UserInfo\022#\n\010b" +
                        "aseResp\030\377\001 \001(\0132\020.common.BaseResp\"%\n\022Sear" +
                        "chUsersRequest\022\017\n\007keyword\030\001 \001(\t\"`\n\023Searc" +
                        "hUsersResponse\022$\n\nuser_infos\030\001 \003(\0132\020.act" +
                        "ion.UserInfo\022#\n\010baseResp\030\377\001 \001(\0132\020.common" +
                        ".BaseResp\"9\n\rFollowRequest\022\024\n\014from_user_" +
                        "id\030\001 \001(\003\022\022\n\nto_user_id\030\002 \001(\003\"5\n\016FollowRe" +
                        "sponse\022#\n\010baseResp\030\377\001 \001(\0132\020.common.BaseR" +
                        "esp\"=\n\020MIsFollowRequest\022\024\n\014from_user_id\030",
                "\001 \001(\003\022\023\n\013to_user_ids\030\002 \003(\003\"\241\002\n\021MIsFollow" +
                        "Response\022@\n\014is_following\030\001 \003(\0132*.action." +
                        "MIsFollowResponse.IsFollowingEntry\022>\n\013is" +
                        "_follower\030\002 \003(\0132).action.MIsFollowRespon" +
                        "se.IsFollowerEntry\022#\n\010baseResp\030\377\001 \001(\0132\020." +
                        "common.BaseResp\0322\n\020IsFollowingEntry\022\013\n\003k" +
                        "ey\030\001 \001(\003\022\r\n\005value\030\002 \001(\010:\0028\001\0321\n\017IsFollowe" +
                        "rEntry\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030\002 \001(\010:\0028\001\"Z" +
                        "\n\024GetFollowListRequest\022\017\n\007user_id\030\001 \001(\003\022" +
                        "\020\n\010min_time\030\002 \001(\003\022\020\n\010max_time\030\003 \001(\003\022\r\n\005c",
                "ount\030\004 \001(\003\"o\n\025GetFollowListResponse\022\020\n\010u" +
                        "ser_ids\030\001 \003(\003\022\r\n\005total\030\002 \001(\003\022\020\n\010has_more" +
                        "\030\003 \001(\010\022#\n\010baseResp\030\377\001 \001(\0132\020.common.BaseR" +
                        "esp\"n\n\026MGetFollowCountRequest\022\020\n\010user_id" +
                        "s\030\001 \003(\003\022\026\n\016need_following\030\002 \001(\010\022\025\n\rneed_" +
                        "follower\030\003 \001(\010\022\023\n\013need_friend\030\004 \001(\010\"\301\003\n\027" +
                        "MGetFollowCountResponse\022L\n\017following_cou" +
                        "nt\030\001 \003(\01323.action.MGetFollowCountRespons" +
                        "e.FollowingCountEntry\022J\n\016follower_count\030" +
                        "\002 \003(\01322.action.MGetFollowCountResponse.F",
                "ollowerCountEntry\022F\n\014friend_count\030\003 \003(\0132" +
                        "0.action.MGetFollowCountResponse.FriendC" +
                        "ountEntry\022#\n\010baseResp\030\377\001 \001(\0132\020.common.Ba" +
                        "seResp\0325\n\023FollowingCountEntry\022\013\n\003key\030\001 \001" +
                        "(\003\022\r\n\005value\030\002 \001(\003:\0028\001\0324\n\022FollowerCountEn" +
                        "try\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030\002 \001(\003:\0028\001\0322\n\020F" +
                        "riendCountEntry\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030\002 " +
                        "\001(\003:\0028\0012\357\006\n\rActionService\0226\n\005Login\022\024.act" +
                        "ion.LoginRequest\032\025.action.LoginResponse\"" +
                        "\000\022?\n\010Register\022\027.action.RegisterRequest\032\030",
                ".action.RegisterResponse\"\000\022K\n\014GetUserInf" +
                        "os\022\033.action.GetUserInfosRequest\032\034.action" +
                        ".GetUserInfosResponse\"\000\022H\n\013SearchUsers\022\032" +
                        ".action.SearchUsersRequest\032\033.action.Sear" +
                        "chUsersResponse\"\000\0229\n\006Follow\022\025.action.Fol" +
                        "lowRequest\032\026.action.FollowResponse\"\000\022;\n\010" +
                        "Unfollow\022\025.action.FollowRequest\032\026.action" +
                        ".FollowResponse\"\000\022E\n\014MIsFollowing\022\030.acti" +
                        "on.MIsFollowRequest\032\031.action.MIsFollowRe" +
                        "sponse\"\000\022D\n\013MIsFollower\022\030.action.MIsFoll",
                "owRequest\032\031.action.MIsFollowResponse\"\000\022Q" +
                        "\n\020GetFollowingList\022\034.action.GetFollowLis" +
                        "tRequest\032\035.action.GetFollowListResponse\"" +
                        "\000\022P\n\017GetFollowerList\022\034.action.GetFollowL" +
                        "istRequest\032\035.action.GetFollowListRespons" +
                        "e\"\000\022N\n\rGetFriendList\022\034.action.GetFollowL" +
                        "istRequest\032\035.action.GetFollowListRespons" +
                        "e\"\000\022T\n\017MGetFollowCount\022\036.action.MGetFoll" +
                        "owCountRequest\032\037.action.MGetFollowCountR" +
                        "esponse\"\000B=\n&violet.gateway.common.proto",
                "_gen.actionP\001Z\021/proto_gen/actionb\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                violet.gateway.common.proto_gen.common.Common.getDescriptor(),
                        }, assigner);
        internal_static_action_LoginRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_action_LoginRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_LoginRequest_descriptor,
                new java.lang.String[]{"Username", "Password",});
        internal_static_action_LoginResponse_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_action_LoginResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_LoginResponse_descriptor,
                new java.lang.String[]{"UserId", "BaseResp",});
        internal_static_action_RegisterRequest_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_action_RegisterRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_RegisterRequest_descriptor,
                new java.lang.String[]{"Username", "Password", "ConfirmPassword",});
        internal_static_action_RegisterResponse_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_action_RegisterResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_RegisterResponse_descriptor,
                new java.lang.String[]{"BaseResp",});
        internal_static_action_UserInfo_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_action_UserInfo_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_UserInfo_descriptor,
                new java.lang.String[]{"UserId", "Username", "Avatar",});
        internal_static_action_GetUserInfosRequest_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_action_GetUserInfosRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_GetUserInfosRequest_descriptor,
                new java.lang.String[]{"UserIds",});
        internal_static_action_GetUserInfosResponse_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_action_GetUserInfosResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_GetUserInfosResponse_descriptor,
                new java.lang.String[]{"UserInfos", "BaseResp",});
        internal_static_action_SearchUsersRequest_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_action_SearchUsersRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_SearchUsersRequest_descriptor,
                new java.lang.String[]{"Keyword",});
        internal_static_action_SearchUsersResponse_descriptor =
                getDescriptor().getMessageTypes().get(8);
        internal_static_action_SearchUsersResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_SearchUsersResponse_descriptor,
                new java.lang.String[]{"UserInfos", "BaseResp",});
        internal_static_action_FollowRequest_descriptor =
                getDescriptor().getMessageTypes().get(9);
        internal_static_action_FollowRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_FollowRequest_descriptor,
                new java.lang.String[]{"FromUserId", "ToUserId",});
        internal_static_action_FollowResponse_descriptor =
                getDescriptor().getMessageTypes().get(10);
        internal_static_action_FollowResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_FollowResponse_descriptor,
                new java.lang.String[]{"BaseResp",});
        internal_static_action_MIsFollowRequest_descriptor =
                getDescriptor().getMessageTypes().get(11);
        internal_static_action_MIsFollowRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MIsFollowRequest_descriptor,
                new java.lang.String[]{"FromUserId", "ToUserIds",});
        internal_static_action_MIsFollowResponse_descriptor =
                getDescriptor().getMessageTypes().get(12);
        internal_static_action_MIsFollowResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MIsFollowResponse_descriptor,
                new java.lang.String[]{"IsFollowing", "IsFollower", "BaseResp",});
        internal_static_action_MIsFollowResponse_IsFollowingEntry_descriptor =
                internal_static_action_MIsFollowResponse_descriptor.getNestedTypes().get(0);
        internal_static_action_MIsFollowResponse_IsFollowingEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MIsFollowResponse_IsFollowingEntry_descriptor,
                new java.lang.String[]{"Key", "Value",});
        internal_static_action_MIsFollowResponse_IsFollowerEntry_descriptor =
                internal_static_action_MIsFollowResponse_descriptor.getNestedTypes().get(1);
        internal_static_action_MIsFollowResponse_IsFollowerEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MIsFollowResponse_IsFollowerEntry_descriptor,
                new java.lang.String[]{"Key", "Value",});
        internal_static_action_GetFollowListRequest_descriptor =
                getDescriptor().getMessageTypes().get(13);
        internal_static_action_GetFollowListRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_GetFollowListRequest_descriptor,
                new java.lang.String[]{"UserId", "MinTime", "MaxTime", "Count",});
        internal_static_action_GetFollowListResponse_descriptor =
                getDescriptor().getMessageTypes().get(14);
        internal_static_action_GetFollowListResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_GetFollowListResponse_descriptor,
                new java.lang.String[]{"UserIds", "Total", "HasMore", "BaseResp",});
        internal_static_action_MGetFollowCountRequest_descriptor =
                getDescriptor().getMessageTypes().get(15);
        internal_static_action_MGetFollowCountRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MGetFollowCountRequest_descriptor,
                new java.lang.String[]{"UserIds", "NeedFollowing", "NeedFollower", "NeedFriend",});
        internal_static_action_MGetFollowCountResponse_descriptor =
                getDescriptor().getMessageTypes().get(16);
        internal_static_action_MGetFollowCountResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MGetFollowCountResponse_descriptor,
                new java.lang.String[]{"FollowingCount", "FollowerCount", "FriendCount", "BaseResp",});
        internal_static_action_MGetFollowCountResponse_FollowingCountEntry_descriptor =
                internal_static_action_MGetFollowCountResponse_descriptor.getNestedTypes().get(0);
        internal_static_action_MGetFollowCountResponse_FollowingCountEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MGetFollowCountResponse_FollowingCountEntry_descriptor,
                new java.lang.String[]{"Key", "Value",});
        internal_static_action_MGetFollowCountResponse_FollowerCountEntry_descriptor =
                internal_static_action_MGetFollowCountResponse_descriptor.getNestedTypes().get(1);
        internal_static_action_MGetFollowCountResponse_FollowerCountEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MGetFollowCountResponse_FollowerCountEntry_descriptor,
                new java.lang.String[]{"Key", "Value",});
        internal_static_action_MGetFollowCountResponse_FriendCountEntry_descriptor =
                internal_static_action_MGetFollowCountResponse_descriptor.getNestedTypes().get(2);
        internal_static_action_MGetFollowCountResponse_FriendCountEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_action_MGetFollowCountResponse_FriendCountEntry_descriptor,
                new java.lang.String[]{"Key", "Value",});
        violet.gateway.common.proto_gen.common.Common.getDescriptor();
    }

    // @@protoc_insertion_point(outer_class_scope)
}
