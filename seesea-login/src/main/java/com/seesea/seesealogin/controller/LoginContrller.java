package com.seesea.seesealogin.controller;

import com.seesea.seeseacommon.Base.BaseController;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.Base.Result;
import com.seesea.seesealogin.model.vo.LoginVo;
import com.seesea.seesealogin.model.vo.TripartiteVo;
import com.seesea.seesealogin.service.ILogService;
import com.seesea.seesealogin.service.ITripartiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/9/15 下午 11:23
 * @Author xiechongyang
 */

@RestController
@RequestMapping(value = "login")
public class LoginContrller extends BaseController {

//    @Value("${server.port}")
//    private String a;

    @Value("${ribbon.ReadTimeout}")
    private String a;
    @Autowired
    private ILogService iLogService;
    @Autowired
    private ITripartiteService iTripartiteService;

//    @HystrixCommand(fallbackMethod = "loginfallbackMethod")
    @PostMapping(value = "/lg")
    public Object login(LoginVo loginVo) throws BizException {
        Result result = loginVo.getResult();
        Map map = iLogService.login(loginVo);
        result.setData(map);
        return result;
    }


    @PostMapping(value = "/tlg")
    public Object tripartiteLogin(TripartiteVo tripartiteVo) throws BizException {
        Result result = tripartiteVo.getResult();
        Map map = iTripartiteService.tripartiteLog(tripartiteVo);
        result.setData(map);
        return result;
    }

    @GetMapping(value = "/test")
    public Object test() throws BizException {
//        Result result = tripartiteVo.getResult();
//        Map map = iTripartiteService.tripartiteLog(tripartiteVo);
//        result.setData(map);
        return a;
    }
    public void loginfallbackMethod(){

    }
}
