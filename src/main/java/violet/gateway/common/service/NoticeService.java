package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface NoticeService {
    JSONObject getNoticeList(JSONObject req) throws Exception;

    JSONObject getNoticeMergeList(JSONObject req) throws Exception;

    JSONObject getNoticeCount(JSONObject req) throws Exception;

    JSONObject markNoticeRead(JSONObject req) throws Exception;
}
