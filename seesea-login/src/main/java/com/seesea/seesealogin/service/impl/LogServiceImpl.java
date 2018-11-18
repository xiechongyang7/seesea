package com.seesea.seesealogin.service.impl;

import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.Base.BaseService;
import com.seesea.seeseacommon.constant.Const;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.token.TokenGenerate;
import com.seesea.seeseacommon.token.TokenInfo;
import com.seesea.seeseacommon.util.IdGenerate;
import com.seesea.seeseacommon.util.date.DateUtils;
import com.seesea.seeseacommon.util.str.StringUtil;
import com.seesea.seesealogin.mapper.LoginLogPoMapper;
import com.seesea.seesealogin.mapper.LoginPoMapper;
import com.seesea.seesealogin.model.po.LoginLogPo;
import com.seesea.seesealogin.model.po.LoginPo;
import com.seesea.seesealogin.model.vo.LoginVo;
import com.seesea.seesealogin.service.ILogService;
import com.seesea.seesealogin.service.feign.IUserfeignService;
import org.apache.catalina.LifecycleState;
import org.omg.PortableServer.AdapterActivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/2 下午 4:56
 * @Author xiechongyang
 */
@Service
public class LogServiceImpl extends BaseService implements ILogService  {


    @Autowired
    private LoginLogPoMapper loginLogPoMapper;

    @Autowired
    private LoginPoMapper loginPoMapper;

    @Autowired
    private TokenGenerate tokenGenerate;

    @Value("${jwt.live.day}")
    private int jwt_live_day;
    @Override
    public Map<String, Object> login(LoginVo loginVo) throws BizException {

////        String a = iUserfeignService.findById("111");
        String ip = loginVo.getIp();
        String acct = loginVo.getLogName();
        String token=  null;
        String userId = null;
        LoginLogPo loginLogPo = new LoginLogPo();

        try{
            //校验是否有这个用户
            LoginPo loginPo = loginPoMapper.selectByAcct(acct);
            if(loginPo==null){
                throw new BizException(ResultCode.ER_1105,ResultCode.ER_1105_MSG);
            }
            //邮箱注册的要去验证
            if(Const.REGISTER_EMAILNOCHECK.equals(loginPo.getStatu())){
                throw new BizException(ResultCode.ER_1105,ResultCode.ER_1105_MSG);
            }
            userId = loginPo.getUserId();
            //校验登录密码
            //密码在网关md5了
            if(!loginPo.getLoginPwd().equals(loginVo.getPwd())){
                throw new BizException(ResultCode.ER_1106,ResultCode.ER_1106_MSG);
            }
            //校验登录ip
            if(!StringUtil.isNull(loginVo.getIp())){
                //TODO 根据IP获取地址信息
            }
            //校验登录时间
            //token
            if(DateUtils.getOverdueDays(loginPo.getLastLoginTime(),new Date())>jwt_live_day){
                TokenInfo tokenInfo = new TokenInfo();
                tokenInfo.setUserId(userId);
//                tokenInfo.setLoginType(loginPo.get);
                token = tokenGenerate.createToken(tokenInfo);
                loginPo.setLoginToken(token);
            }else {
                token = loginPo.getLoginToken();
            }
            //修改表
            loginPo.setLastLoginTime(new Date());
            loginPoMapper.updateByPrimaryKey(loginPo);

            loginLogPo.setRemark("登录成功");
            loginLogPo.setLoginToken(token);
            loginLogPo.setLoginResult(Const.LOGI_SUCCESS);

            //返回
            Map map = new HashMap();
            map.put("msg","登录成功");
            map.put("token",token);
            return map;

        }catch (BizException e){
            loginLogPo.setRemark("登录失败");
            loginLogPo.setLoginResult(Const.LOGI_FAIL);
            throw e;
        }finally {
            if(!StringUtil.isNull(userId)){
                loginLogPo.setUserId(userId);
                loginLogPo.setLoginId(IdGenerate.getLoginId());
                loginLogPo.setLoginTime(new Date());
                loginLogPo.setLoginIp(ip);
                loginLogPoMapper.insert(loginLogPo);
            }
        }

    }
}
