package com.blog.blogsit.controller;

import java.util.List;

import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.model.Supplier;
import com.blog.blogsit.service.supplier.SupplierManageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

/**
 * 功能描述：<br>
 *
 * @author hua.chen 2015年6月24日 下午3:46:06 <br>
 *         修改记录:
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends AbstractController {
    @Autowired
    private SupplierManageImpl  supplierManageImpl;
    @RequestMapping(value = "/genCityJson.htm", produces="application/json")
    @ResponseBody
    public APIResult<List<String>> genJson() {
        List<String> cityList = Lists.newArrayList();
        cityList.add("北京");
        cityList.add("上海");
        return APIResult.buildSuccessResult(cityList);
    }
    @RequestMapping(value = "/querySupplierId.htm", produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public APIResult<Supplier> genJson(@RequestParam long supplierId) {
        return APIResult.buildSuccessResult(supplierManageImpl.querySupplierById(supplierId));
    }

    @RequestMapping(value = "/queryCity.htm", produces="application/json")
    @ResponseBody
    public APIResult<List<String>> queryCtiy() {
        List<String> cityList = Lists.newArrayList();
        cityList.add("北京");
        cityList.add("上海");
        return APIResult.buildSuccessResult(cityList);
    }

}
