package com.seesea.seesealogin.service.impl;

import com.seesea.seeseacommon.Base.BaseService;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import com.seesea.seeseacommon.util.str.StringUtil;
import com.seesea.seesealogin.mapper.LoginLogPoMapper;
import com.seesea.seesealogin.mapper.LoginPoMapper;
import com.seesea.seesealogin.model.po.LoginLogPo;
import com.seesea.seesealogin.model.po.LoginPo;
import com.seesea.seesealogin.model.vo.TripartiteVo;
import com.seesea.seesealogin.service.ITripartiteLogService;
import com.seesea.seesealogin.service.ITripartiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/5 下午 10:43
 * @Author xiechongyang
 */
@Service
public class TripartiteLogImpl extends BaseService implements ITripartiteLogService {
    @Autowired
    LoginPoMapper loginPoMapper;

    @Autowired
    LoginLogPoMapper loginLogPoMapper;

    @Override
    public Map<String, Object> tripartiteLog(TripartiteVo tripartiteVo) {

        LoginPo loginPo = new LoginPo();


        try{
            String type = tripartiteVo.getType();
            ITripartiteService iTripartiteService = SpringContextUtil.getBean(type, ITripartiteService.class);
            Map<String,Object> map = iTripartiteService.tripartiteLog(tripartiteVo);
            //校验登录ip
            if(!StringUtil.isNull(tripartiteVo.getIp())){
                //TODO 根据IP获取地址信息
                throw new Exception();
            }

            loginPo.setLoginToken(tripartiteVo.getAuthCode());
//            loginPo.setUserId();

            //修改表

        }catch (BizException e){

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            loginPo.setLastLoginTime(new Date());
//            loginPo.setStatu();
//            loginPo.setRemark();
//            loginPo.setLoginPwd();
//            loginPo.setLoginAccount();
//            loginPoMapper.insert();
//
//            LoginLogPo loginLogPo = new LoginLogPo();
//            loginLogPo.setLoginResult();
//            loginLogPo.setLoginIp();
//            loginLogPo.setLoginTime();
//            loginLogPo.setLoginToken();
//            loginLogPo.setRemark();
//            loginLogPo.setUserId();
//            loginLogPo.setLoginId();
//            loginLogPoMapper.insert();
        }


        return null;
    }
}
