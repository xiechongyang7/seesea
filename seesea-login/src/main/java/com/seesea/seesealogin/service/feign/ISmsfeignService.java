package com.seesea.seesealogin.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/6 下午 9:30
 * @Author xiechongyang
 */

@FeignClient("seesea-sms")
public interface ISmsfeignService {

    @RequestMapping(value = "/sms/checkvcode", method = RequestMethod.POST)
    public Map checkVCode(@RequestBody Map map);
}
