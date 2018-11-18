package com.seesea.seesealogin.service;


import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seesealogin.model.vo.LoginVo;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/2 下午 4:56
 * @Author xiechongyang
 */
public interface ILogService {

    Map<String,Object> login(LoginVo loginVo) throws BizException;

}
