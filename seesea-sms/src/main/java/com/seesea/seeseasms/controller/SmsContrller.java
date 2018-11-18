package com.seesea.seeseasms.controller;

import com.seesea.seeseacommon.Base.BaseController;
import com.seesea.seeseacommon.Base.ReqVoCommon;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.Base.Result;
import com.seesea.seeseacommon.util.JsonUtil;
import com.seesea.seeseasms.model.vo.CheckSmsVo;
import com.seesea.seeseasms.model.vo.SendSmsVo;
import com.seesea.seeseasms.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/9/15 下午 11:23
 * @Author xiechongyang
 */

@RestController
@RequestMapping(value = "sms")
public class SmsContrller extends BaseController {

    @Autowired
    private ISmsService iSmsService;

//    @HystrixCommand(fallbackMethod = "SendSmsfallbackMethod")
    @PostMapping(value = "/sendvcode")
    public Object sendvcode(SendSmsVo sendSmsVo) throws BizException {

        Result result = sendSmsVo.getResult();
        Map map = iSmsService.send(sendSmsVo);
        result.setData(map);

        return result;

    }

    @PostMapping(value = "/checkvcode")
    public Object checkvcode(CheckSmsVo checkSmsVo) throws BizException {

        Result result = checkSmsVo.getResult();
        Map map = iSmsService.checkVCode(checkSmsVo);
        result.setData(map);

        return result;

    }


    public void loginfallbackMethod(){

    }
}
