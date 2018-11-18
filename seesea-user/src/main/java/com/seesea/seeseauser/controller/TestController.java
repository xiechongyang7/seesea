package com.seesea.seeseauser.controller;

import com.seesea.seeseacommon.Base.BaseController;
import com.seesea.seeseacommon.Base.exception.BizException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/3 下午 3:59
 * @Author xiechongyang
 */
@RestController
@RefreshScope
public class TestController extends BaseController {


    @Value("${test}")
    private String a;

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public Object logiqn(@PathVariable("id")String id) throws BizException {
//    throw new BizException("d","d");
//        logInfo(id,a,a);
        return a;

    }
}
