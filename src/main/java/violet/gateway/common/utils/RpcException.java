package violet.gateway.common.utils;

import violet.gateway.common.proto_gen.common.BaseResp;

public class RpcException extends Exception {
    private final BaseResp baseResp;

    public RpcException(BaseResp baseResp) {
        super();
        this.baseResp = baseResp;
    }

    public BaseResp getStatus() {
        return baseResp;
    }
}
