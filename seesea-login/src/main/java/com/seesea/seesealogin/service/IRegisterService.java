package com.seesea.seesealogin.service;

import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seesealogin.model.vo.RegisterVo;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/23 下午 11:52
 * @Author xiechongyang
 */
public interface IRegisterService {

    Map<String,Object> register(RegisterVo registerVo) throws BizException;
}
