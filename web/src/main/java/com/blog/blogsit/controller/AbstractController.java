package com.blog.blogsit.controller;

import com.blog.blogsit.base.impl.APIResult;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2015年6月30日 上午10:01:57 <br>
 *         修改记录:
 */
public abstract class AbstractController {
    @InitBinder(value = {"createTime","updateTime"})
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor editor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, editor);
    }
    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResult<Void> handleException(HttpServletRequest req, Exception e) {
        StringBuilder monitorKey = new StringBuilder().append("Blogsit_");
        Map<RequestMappingInfo,HandlerMethod> map = handlerMapping.getHandlerMethods();
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            RequestMappingInfo key = (RequestMappingInfo) pairs.getKey();
            if (key.getPatternsCondition().getMatchingCondition(req) != null) {
                monitorKey.append(key.getPatternsCondition().getMatchingCondition(req).getPatterns()).append("_Exception");
                break;
            }
        }
        return APIResult.buildFailedResult(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public APIResult<Void> handleValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String message = processFieldErrors(fieldErrors);
        return APIResult.buildFailedResult(message);
    }
    private String processFieldErrors(List<FieldError> fieldErrors) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError: fieldErrors) {
            stringBuilder.append(fieldError.getDefaultMessage());
        }
        return stringBuilder.toString();
    }
}
