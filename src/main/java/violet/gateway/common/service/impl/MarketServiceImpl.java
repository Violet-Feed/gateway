package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.market.*;
import violet.gateway.common.service.MarketService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.List;

@Slf4j
@Service
public class MarketServiceImpl implements MarketService {
    @GrpcClient("market")
    private MarketServiceGrpc.MarketServiceBlockingStub marketStub;

    @Override
    public JSONObject createItem(JSONObject req) throws Exception {
        String title = req.getString("title");
        List<String> images = req.getJSONArray("images").toJavaList(String.class);
        CreateItemRequest createItemRequest = CreateItemRequest.newBuilder()
                .setTitle(title)
                .addAllImages(images)
                .build();
        CreateItemResponse createItemResponse = marketStub.createItem(createItemRequest);
        if (createItemResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createItem] CreateItem rpc err, err = {}", createItemResponse.getBaseResp());
            throw new RpcException(createItemResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getItemProfile(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long itemId = req.getLong("item_id");
        GetItemInfoRequest getItemInfoRequest = GetItemInfoRequest.newBuilder()
                .setItemId(itemId)
                .build();
        GetItemInfoResponse getItemInfoResponse = marketStub.getItemInfo(getItemInfoRequest);
        if (getItemInfoResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getItemProfile] GetItemInfo rpc err, err = {}", getItemInfoResponse.getBaseResp());
            throw new RpcException(getItemInfoResponse.getBaseResp());
        }
        AppendItemHistoryRequest appendItemHistoryRequest = AppendItemHistoryRequest.newBuilder()
                .setUserId(userId)
                .setItemId(itemId)
                .build();
        AppendItemHistoryResponse appendItemHistoryResponse = marketStub.appendItemHistory(appendItemHistoryRequest);
        if (appendItemHistoryResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getItemProfile] AppendItemHistory rpc err, err = {}", appendItemHistoryResponse.getBaseResp());
            throw new RpcException(appendItemHistoryResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("item_info", getItemInfoResponse.getItemInfo());
        data.put("properties", getItemInfoResponse.getPropertiesList());
        data.put("skus", getItemInfoResponse.getSkusList());
        data.put("shop_info", getItemInfoResponse.getShop());
        return data;
    }

    @Override
    public JSONObject getItemsByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        GetItemListByUserRequest getItemListByUserRequest = GetItemListByUserRequest.newBuilder()
                .setUserId(userId)
                .build();
        GetItemListByUserResponse getItemListByUserResponse = marketStub.getItemListByUser(getItemListByUserRequest);
        if (getItemListByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getItemsByUser] GetItemListByUser rpc err, err = {}", getItemListByUserResponse.getBaseResp());
            throw new RpcException(getItemListByUserResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("items", getItemListByUserResponse.getItemsList());
        return data;
    }

    @Override
    public JSONObject getItemsBySearch(JSONObject req) throws Exception {
        String keyword = req.getString("keyword");
        Long page = req.getLong("page");
        GetItemListBySearchRequest getItemListBySearchRequest = GetItemListBySearchRequest.newBuilder()
                .setKeyword(keyword)
                .setPage(page)
                .build();
        GetItemListBySearchResponse getItemListBySearchResponse = marketStub.getItemListBySearch(getItemListBySearchRequest);
        if (getItemListBySearchResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getItemsBySearch] GetItemListBySearch rpc err, err = {}", getItemListBySearchResponse.getBaseResp());
            throw new RpcException(getItemListBySearchResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("items", getItemListBySearchResponse.getItemsList());
        return data;
    }
}
