package com.blog.blogsit.controller;

import java.util.List;

import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.base.impl.APIResult;
import com.blog.blogsit.base.impl.APIResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/genCityJson.htm")
    @ResponseBody
    public APIResult<List<String>> genJson() {
        List<String> cityList = Lists.newArrayList();
        cityList.add("北京");
        cityList.add("上海");
        return APIResult.buildSuccessResult(cityList);
    }

    @RequestMapping(value = "/queryCity.htm")
    @ResponseBody
    public APIResult<List<String>> queryCtiy() {
        List<String> cityList = Lists.newArrayList();
        cityList.add("北京");
        cityList.add("上海");
        return APIResult.buildSuccessResult(cityList);
    }

}
