package com.seesea.seesealogin.service.impl;

import com.seesea.seeseacommon.Base.BaseService;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.constant.Const;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.token.TokenGenerate;
import com.seesea.seeseacommon.token.TokenInfo;
import com.seesea.seeseacommon.util.IdGenerate;
import com.seesea.seeseacommon.util.JsonUtil;
import com.seesea.seeseacommon.util.str.StringUtil;
import com.seesea.seesealogin.mapper.LoginLogPoMapper;
import com.seesea.seesealogin.mapper.LoginPoMapper;
import com.seesea.seesealogin.mapper.RegisterPoMapper;
import com.seesea.seesealogin.model.po.LoginLogPo;
import com.seesea.seesealogin.model.po.LoginPo;
import com.seesea.seesealogin.model.po.RegisterPo;
import com.seesea.seesealogin.model.vo.RegisterVo;
import com.seesea.seesealogin.service.IRegisterService;
import com.seesea.seesealogin.service.feign.ISmsfeignService;
import com.seesea.seesealogin.service.feign.IUserfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/23 下午 11:54
 * @Author xiechongyang
 */
@Service
public class RegisterServiceImpl extends BaseService implements IRegisterService {

    @Autowired
    private IUserfeignService iUserfeignService;

    @Autowired
    private RegisterPoMapper registerPoMapper;

    @Autowired
    private LoginLogPoMapper loginLogPoMapper;

    @Autowired
    private LoginPoMapper loginPoMapper;

    @Autowired
    private TokenGenerate tokenGenerate;

    @Autowired
    private ISmsfeignService iSmsfeignService;
    /**
     * 普通注册
     * @param registerVo
     * @return
     */
    @Override
    public Map<String, Object> register(RegisterVo registerVo) throws BizException {


        String acct = registerVo.getRegisterName();
        String type = registerVo.getRegisterType();
        RegisterPo registerPo = new RegisterPo();
        String ip = registerVo.getIp();
        try{

            String loginAddress= null;
            //1 检查是否有这个账户了
//        String a = iUserfeignService.isHaveUser("111");
            LoginPo loginPo = loginPoMapper.selectByAcct(acct);
            if(loginPo!=null){
                throw new BizException(ResultCode.ER_1104,ResultCode.ER_1104_MSG);
            }
            loginPo = new LoginPo();


            //2 判断校验信息
            //2.1 短信就直接校验
            //2.2 邮箱就发送邮件
            if(Const.REGISTER_TYPE_PHONE.equals(type)){
                //TODO 调用短信校验
                Map map = new HashMap();
                map.put("reqId", UUID.randomUUID().toString().substring(20));
                map.put("phone",registerVo.getRegisterName());
                map.put("vcode",registerVo.getVcode());
                map.put("workType","1");
//                Map re = iSmsfeignService.checkVCode(JsonUtil.objToJson(map));
                Map re = iSmsfeignService.checkVCode(map);
                logInfo(registerVo.getReqId(),"短信服务返回参数",map);
                if("".equals(re.get("code"))||!"200".equals(re.get("code"))){
                    throw new BizException(ResultCode.ER_1109,!"".equals(re.get("msg"))||re.get("msg")!=null?re.get("msg").toString():ResultCode.ER_1109_MSG);
                }
            }else if(Const.REGISTER_TYPE_EMIAL.equals(type)){
                //TODO 发送邮件
            }

            //2.3
            if(!StringUtil.isNull(ip)){
                //TODO 根据IP获取地址信息
                loginAddress = "上海";
            }

            //3 生成登录userID的 和 登录token
            String userId = IdGenerate.getUserId();
            TokenInfo tokenInfo = new TokenInfo();
            tokenInfo.setUserId(userId);
//            tokenInfo.setLoginType(type);

            String token = tokenGenerate.createToken(tokenInfo);

//            LoginPo loginPo = new LoginPo();
            //4 存入登录表 和 登录登录日志表
            loginPo.setLastLoginTime(new Date());
            loginPo.setLoginAccount(acct);
            loginPo.setLoginPwd(registerVo.getPwd());
            loginPo.setLoginToken(token);
//            loginPo.setRemark();
            if(Const.REGISTER_TYPE_PHONE.equals(type)){
                loginPo.setStatu(Const.REGISTER_SUCCESS);
            }else if(Const.REGISTER_TYPE_EMIAL.equals(type)){
                loginPo.setStatu(Const.REGISTER_EMAILNOCHECK);
            }
            loginPo.setUserId(userId);
            loginPoMapper.insert(loginPo);

            LoginLogPo loginLogPo = new LoginLogPo();
            loginLogPo.setLoginId(IdGenerate.getLoginId());
            loginLogPo.setLoginIp(ip);
            loginLogPo.setLoginResult(Const.LOGI_SUCCESS);
            loginLogPo.setLoginTime(new Date());
            loginLogPo.setLoginToken(token);
            loginLogPo.setRemark("首次登录");
            loginLogPo.setUserId(userId);


            loginLogPoMapper.insert(loginLogPo);
            registerPo.setStatus(Const.REGISTER_SUCCESS);

            Map map = new HashMap();
            map.put("token",token);
            map.put("msg","注册成功");
            map.put("type",type);
            map.put("loginAddress",loginAddress);

            //TODO 发送user-service

            return map;
        }catch (BizException e){
            registerPo.setStatus(Const.REGISTER_FAIL);
            registerPo.setRemark(e.getMessage());
            throw e;
        }catch (Exception e){
            logError("re","cd",e);
            throw e;
        } finally{
            //4 修改
            //todo 失败不插入
            if(registerPo.getStatus()!=null){
            registerPo.setRegisterAcct(acct);
            registerPo.setRegisterTime(new Date());
            registerPo.setRegisterType(type);
            registerPo.setRemark(registerPo.getStatus());
            registerPoMapper.insert(registerPo);
            }
        }
    }
}
