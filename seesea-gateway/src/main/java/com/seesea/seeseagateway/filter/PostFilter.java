package com.seesea.seeseagateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.util.JsonUtil;
import com.seesea.seeseacommon.util.LogUtil;
import com.seesea.seeseagateway.entity.ReqParam;
import com.seesea.seeseagateway.entity.RspParam;
import com.seesea.seeseagateway.mapper.GatewayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description
 * @Since JDK1.8
 * @Createtime 18:04 2018/9/13
 * @Author 谢重阳
 */
@Component
public class PostFilter extends ZuulFilter {

    @Autowired
    private GatewayMapper gatewayMapper;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        ReqParam reqParam = PreFilter.thread.get();
        RequestContext ctx = RequestContext.getCurrentContext();
        Boolean isSend = ctx.sendZuulResponse();
        String rspStr = null;
        try {
            if (isSend) {
                if (ctx.getResponseStatusCode() >= 200 && ctx.getResponseStatusCode() < 300) {
                    rspStr = StreamUtils.copyToString(ctx.getResponseDataStream(), Charset.forName("UTF-8"));
                    LogUtil.logInfo(reqParam.getReqId(), "网关返回参数", rspStr);

                    /**
                     * 返回信息入库保存
                     */
                    Map map = JsonUtil.jsonToObj(rspStr, Map.class);
                    RspParam rspParam = new RspParam();
                    rspParam.setCode(map.get("code").toString());
                    rspParam.setMsg(map.get("msg").toString());
                    rspParam.setData(rspStr);
                    rspParam.setRspTime(new Date());
                    rspParam.setReqId(reqParam.getReqId());
                    gatewayMapper.putGateway(rspParam);
                }
            } else {
                /**
                 * 没有进行路由的外网管信息也保存
                 */
                rspStr = ctx.getResponseBody();
                RspParam rspParam = JsonUtil.jsonToObj(rspStr, RspParam.class);
                /**
                 * 流水号重复不修改
                 */
                if (!ResultCode.ER_1000.equals(rspParam.getCode())) {
                    rspStr = ctx.getResponseBody();
                    rspParam.setRspTime(new Date());
                    rspParam.setReqId(reqParam.getReqId());

                    gatewayMapper.putGateway(rspParam);
                }
            }
            ctx.setResponseBody(rspStr);
        } catch (Exception e) {
            RspParam rspParam = new RspParam();
            rspParam.setCode(ResultCode.ER_1004);
            rspParam.setMsg(ResultCode.ER_1004_MSG);
            rspParam.setData(rspStr);
            rspParam.setRspTime(new Date());
            rspParam.setReqId(reqParam.getReqId());
            gatewayMapper.putGateway(rspParam);
            LogUtil.logError(reqParam.getReqId(), "网关返回参数处理错误",  e);
            rspStr = JsonUtil.objToJson(rspParam);

            ctx.setResponseBody(rspStr);
        }
        return null;
    }
}
