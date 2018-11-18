package com.seesea.seeseauser.controller;

import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.constant.Const;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/29 下午 11:38
 * @Author xiechongyang
 */
@RestController
@RefreshScope
public class UserInfoController {


    @GetMapping(value = "/user/{id}")
    public Object isHaveUser(@PathVariable("id")String id) throws BizException {
        return Const.SUCCESS;
    }

}
