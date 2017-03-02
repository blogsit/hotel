package com.blog.blogsit.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

/**
 * 
 * 功能描述：<br>
 * 使用 future 返回值的方式实现
 * 
 * @author hua.chen 2016年1月22日 下午2:57:17 <br>
 *         修改记录:
 */
public class ConcurrentAuditOrder {
    private ExecutorService exec;
    private List<Future<Map<String, Object>>> tasks = new ArrayList<Future<Map<String, Object>>>();

    public ConcurrentAuditOrder() {
        exec = Executors.newFixedThreadPool(10);
    }

    public List<Map<String, Object>> auditOrder(String ebAccount, JSONArray jsonArray) {
        List<Map<String, Object>> result = Lists.newArrayList();
        if (jsonArray != null) {
            for (Object object : jsonArray) {
                JSONObject jsonObjectOrder = (JSONObject) object;
                AuditOrderCallable auditOrderCallable = new AuditOrderCallable(ebAccount, jsonObjectOrder);
                FutureTask<Map<String, Object>> future = new FutureTask<Map<String, Object>>(auditOrderCallable);
                tasks.add(future);
                if (!exec.isShutdown()) {
                    exec.submit(future);
                }
            }
            for (Future<Map<String, Object>> task : tasks) {
                try {
                    // 如果计算未完成则阻塞
                    result.add(task.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

    public void close() {
        exec.shutdown();
    }
}
