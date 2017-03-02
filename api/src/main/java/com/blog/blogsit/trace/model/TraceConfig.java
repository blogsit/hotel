package com.blog.blogsit.trace.model;

/**
 * 追踪配置
 *
 * @author hua.chen
 * @date 2017年02月28 17:11
 */
public interface TraceConfig {
    String RPC_TRACE_INFO_KEY = "blogsit_trace_info_key";

    String LOG_TRACE_KEY = "traceId";

    String LOG_GLOBAL_KEY = "globalId";

    String LOG_UUID_KEY = "UUID";

    String LOG_USERNAME_KEY = "userName";

    String HTTP_HEADER_KEY = "TRACE-ID";

    String ROOT_PATH = "0";
}
