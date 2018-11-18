package com.seesea.seesealogin.controller;

import com.seesea.seeseacommon.Base.BaseController;
import com.seesea.seeseacommon.Base.Result;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seesealogin.model.vo.RegisterVo;
import com.seesea.seesealogin.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description 注册
 * @Since JDK1.8
 * @Createtime 2018/10/23 下午 11:07
 * @Author xiechongyang
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterContrller extends BaseController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping(value = "/normal")
    public Object register(RegisterVo registerVo) throws BizException {
        Result result = registerVo.getResult();
        Map<String,Object> map = registerService.register(registerVo);
        result.setData(map);
        return result;
    }
}
