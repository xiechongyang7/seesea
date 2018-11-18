package com.seesea.seesealogin.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/3 下午 3:55
 * @Author xiechongyang
 */
@FeignClient("seesea-user")
public interface IUserfeignService {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String isHaveUser(@PathVariable("id")String id);

}
