package com.blog.blogsit.executor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * 功能描述：<br>
 * 审核订单带返回值
 * 
 * @author hua.chen 2016年1月22日 下午2:53:43 <br>
 *         修改记录:
 */
public class AuditOrderCallable implements Callable<Map<String, Object>> {
    private JSONObject order = null;

    public AuditOrderCallable(String ebAccount, JSONObject order) {
        this.order = order;
    }

    @Override
    public Map<String, Object> call() throws Exception {
        Map<String, Object> params = Maps.newHashMap();
        List<JSONObject> orders = Lists.newArrayList();
        long save_start = System.currentTimeMillis();
        // 构件返回参数
        Map<String, Object> orderMap = Maps.newHashMap();
        orderMap.put("errmsg", "");
        orderMap.put("userAuditOption", order.getString("userAuditOption"));
        orderMap.put("hotelId", Long.valueOf(order.getString("hotelId")));
        orderMap.put("success", false);
        orderMap.put("orderNo", order.getString("orderNo"));
        return orderMap;
    }
}
