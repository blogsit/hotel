package com.blog.blogsit.trace;

import com.blog.blogsit.trace.model.TraceId;
import com.blog.blogsit.trace.model.TraceInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.blog.blogsit.trace.model.TraceConfig.*;


/**
 * HTTP請求追溯類
 *
 * @author hua.chen
 * @date 2017年02月28 16:47
 */
public class HttpTraceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        try {
            TraceId traceId = Tracer.takeTraceId(takeUserIp(httpServletRequest));
            TraceInfo traceInfo = Tracer.initStart(traceId, takeURL(httpServletRequest));

            MDC.put(LOG_TRACE_KEY, traceInfo.asTraceCode());
            MDC.put(LOG_GLOBAL_KEY, takeQunarGlobal(httpServletRequest));
            MDC.put(LOG_UUID_KEY, takeUUID(httpServletRequest));
            MDC.put(LOG_USERNAME_KEY, takeUserName(httpServletRequest));
            httpServletResponse.setHeader(HTTP_HEADER_KEY, traceId.asCode());
        } catch (Exception e) {
        }

        try {
            chain.doFilter(request, httpServletResponse);
        } finally {
            try {
                Tracer.initEnd();
                MDC.remove(LOG_TRACE_KEY);
                MDC.remove(LOG_GLOBAL_KEY);
                MDC.remove(LOG_UUID_KEY);
                MDC.remove(LOG_USERNAME_KEY);
            } catch (Exception e) {
            }
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    public String takeURL(HttpServletRequest httpRequest) {
        StringBuffer urlBuffer = httpRequest.getRequestURL();
        String url;
        if (urlBuffer != null) {
            url = urlBuffer.toString();
        } else {
            url = httpRequest.getRequestURI();
        }
        return url;
    }

    private String takeUserIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        int pos = ip.indexOf(',');
        if (pos >= 0) {
            ip = ip.substring(0, pos);
        }
        return ip;
    }

    private String takeQunarGlobal(HttpServletRequest request){
        return findCookieByName(request, "QunarGlobal");
    }

    private String takeUUID(HttpServletRequest request) {
        return findCookieByName(request, "UID");
    }

    private String takeUserName(HttpServletRequest request) {
        return findCookieByName(request, "_q");
    }


    private String findCookieByName(HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName())) {
                return StringUtils.trimToEmpty(cookie.getValue());
            }
        }
        return StringUtils.EMPTY;
    }


    private String findHeaderByName(HttpServletRequest request, String headerName){
        return StringUtils.trimToEmpty(request.getHeader(headerName));
    }




}
