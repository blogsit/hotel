package com.blog.blogsit.controller;

import java.util.List;

import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.model.VisitOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/visitorder")
public class VisitOrderController extends AbstractController {
    private final Logger logger = LoggerFactory.getLogger(VisitOrderController.class);

    @RequestMapping(value = "/getVisitOrder.htm")
    @ResponseBody
    public APIResult<List<VisitOrder>> getVisitOrder(String userName, String customer) {
        logger.info("查询预约订单参数:用户名{},客户名称{}", userName, customer);
        return APIResult.buildSuccessResult();
    }

    @RequestMapping(value = "/insertVisitOrder.htm")
    @ResponseBody
    public APIResult<Boolean> insertVisitOrder(VisitOrder visitOrder) {
        return APIResult.buildSuccessResult();
    }
}
