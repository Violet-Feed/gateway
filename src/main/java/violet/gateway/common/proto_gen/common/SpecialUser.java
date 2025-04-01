// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/common.proto

package violet.gateway.common.proto_gen.common;

/**
 * Protobuf enum {@code common.SpecialUser}
 */
public enum SpecialUser
        implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SpecialUser_Not_Use = 0;</code>
     */
    SpecialUser_Not_Use(0),
    /**
     * <code>System = 1;</code>
     */
    System(1),
    /**
     * <code>Action = 2;</code>
     */
    Action(2),
    /**
     * <code>Market = 3;</code>
     */
    Market(3),
    /**
     * <code>AI = 4;</code>
     */
    AI(4),
    /**
     * <code>Conversation = 5;</code>
     */
    Conversation(5),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SpecialUser_Not_Use = 0;</code>
     */
    public static final int SpecialUser_Not_Use_VALUE = 0;
    /**
     * <code>System = 1;</code>
     */
    public static final int System_VALUE = 1;
    /**
     * <code>Action = 2;</code>
     */
    public static final int Action_VALUE = 2;
    /**
     * <code>Market = 3;</code>
     */
    public static final int Market_VALUE = 3;
    /**
     * <code>AI = 4;</code>
     */
    public static final int AI_VALUE = 4;
    /**
     * <code>Conversation = 5;</code>
     */
    public static final int Conversation_VALUE = 5;


    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalArgumentException(
                    "Can't get the number of an unknown enum value.");
        }
        return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static SpecialUser valueOf(int value) {
        return forNumber(value);
    }

    public static SpecialUser forNumber(int value) {
        switch (value) {
            case 0:
                return SpecialUser_Not_Use;
            case 1:
                return System;
            case 2:
                return Action;
            case 3:
                return Market;
            case 4:
                return AI;
            case 5:
                return Conversation;
            default:
                return null;
        }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<SpecialUser>
    internalGetValueMap() {
        return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<
            SpecialUser> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<SpecialUser>() {
                public SpecialUser findValueByNumber(int number) {
                    return SpecialUser.forNumber(number);
                }
            };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
    getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor
    getDescriptorForType() {
        return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor
    getDescriptor() {
        return violet.gateway.common.proto_gen.common.Common.getDescriptor().getEnumTypes().get(1);
    }

    private static final SpecialUser[] VALUES = values();

    public static SpecialUser valueOf(
            com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
                    "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
    }

    private final int value;

    private SpecialUser(int value) {
        this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:common.SpecialUser)
}

