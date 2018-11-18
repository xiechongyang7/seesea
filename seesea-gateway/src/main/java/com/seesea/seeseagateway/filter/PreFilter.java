package com.seesea.seeseagateway.filter;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.util.JsonUtil;
import com.seesea.seeseacommon.util.LogUtil;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import com.seesea.seeseacommon.util.collection.MapUtil;
import com.seesea.seeseacommon.util.encrypt.AESUtil;
import com.seesea.seeseacommon.util.encrypt.MD5Util;
import com.seesea.seeseacommon.util.str.StringUtil;
import com.seesea.seeseagateway.entity.GatewayLog;
import com.seesea.seeseagateway.entity.ReqParam;
import com.seesea.seeseagateway.entity.RspParam;
import com.seesea.seeseagateway.entity.ServiceEntity;
import com.seesea.seeseagateway.mapper.GatewayMapper;
import com.seesea.seeseagateway.service.ICheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 18:04 2018/9/13
 * @Author 谢重阳
 */
@Component
public class PreFilter extends ZuulFilter {

    @Value("${MD5Key}")
    private String MD5Key;

    @Value("${AESKey}")
    private String AESKey;

    @Autowired
    private GatewayMapper gatewayMapper;

    protected static ThreadLocal<ReqParam> thread = new ThreadLocal<>();

    /**
     * filterType代表过滤类型
     * PRE: 该类型的filters在Request routing到源web-service之前执行。用来实现Authentication、选择源服务地址等
     * ROUTING：该类型的filters用于把Request routing到源web-service，源web-service是实现业务逻辑的服务。这里使用HttpClient请求web-service。
     * POST：该类型的filters在ROUTING返回Response后执行。用来实现对Response结果进行修改，收集统计数据以及把Response传输会客户端。
     * ERROR：上面三个过程中任何一个出现错误都交由ERROR类型的filters进行处理。
     * 主要关注 pre、post和error。分别代表前置过滤，后置过滤和异常过滤。
     * 如果你的filter是pre的，像上一篇那种，就是指请求先进入pre的filter类，你可以进行一些权限认证，日志记录，或者额外给Request增加一些属性供后续的filter使用。pre会优先按照order从小到大执行，然后再去执行请求转发到业务服务。
     * 再说post，如果type为post，那么就会执行完被路由的业务服务后，再进入post的filter，在post的filter里，一般做一些日志记录，或者额外增加response属性什么的。
     * 最后error，如果在上面的任何一个地方出现了异常，就会进入到type为error的filter中。
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 处理逻辑，权限控制、日志。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        //设置字符集
        response.setCharacterEncoding("UTF-8");
        //设置相应的格式
        response.setContentType("application/json");

        RspParam rspParam = new RspParam();
        rspParam.setCode(ResultCode.SUCCESS);
        ctx.setResponseBody(ResultCode.SUCCESS_MSG);
        // 对该请求进行路由
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(200);
        ReqParam reqParam = null;
        try {
            String reqStr = StreamUtils.copyToString(ctx.getRequest().getInputStream(), Charset.forName("UTF-8"));
            reqParam = JsonUtil.jsonToObj(reqStr, ReqParam.class);
            //todo 有一个签名参数来判断是否有密码 有密码就不打日志了
            LogUtil.logInfo(reqParam.getReqId(), "网关请求日志", reqStr);
            thread.set(reqParam);

            if(reqParam.getServiceId()==null||reqParam.getReqId()==null){
                rspParam.setCode(ResultCode.ER_1006);
                rspParam.setMsg(ResultCode.ER_1006_MSG);
                ctx.setResponseBody(JsonUtil.objToJson(rspParam));
                return null;
            }
            /**
             * 流水号校验
             */
            if (gatewayMapper.getReqId(reqParam.getReqId()) != 0) {
                rspParam.setCode(ResultCode.ER_1000);
                rspParam.setMsg(ResultCode.ER_1000_MSG);
                ctx.setResponseBody(JsonUtil.objToJson(rspParam));
                return null;
            }

            /**
             * 验签
             */
//            if (reqParam.isSign()) {
//                String sortStr = StringUtil.sortValue(reqParam);
//                String signStr = MD5Util.getMd5(sortStr + "&KEY=" + MD5Key);
//                if (!signStr.equals(reqParam.getSign())) {
//                    rspParam.setCode(ResultCode.ER_1001);
//                    rspParam.setMsg(ResultCode.ER_1001_MSG);
//                    ctx.setResponseBody(JsonUtil.objToJson(rspParam));
//
//                    return null;
//                }
//            }

            /**
             * 加密密码
             */
            if (reqParam.isEncrypt()) {

//                dataStr = AESUtil.decrypt(dataStr, AESKey);
//                dataStr = JsonUtil.jsonAddParam(dataStr, "reqId", reqParam.getReqId());
//                reqParam.setData(dataStr);
                Map map = JsonUtil.jsonToObj(reqParam.getData(),Map.class);
                String pwd = (String) map.get("pwd");
                pwd = MD5Util.getMd5(pwd + "&KEY=" + MD5Key);
                map.put("pwd",pwd);
                map.put("reqId", reqParam.getReqId());
//                String str = JsonUtil.jsonAddParam(reqParam.getData(), "reqId", reqParam.getReqId());
                String dataStr = JsonUtil.objToJson(map);
                reqParam.setData(dataStr);
            } else {
                String str = JsonUtil.jsonAddParam(reqParam.getData(), "reqId", reqParam.getReqId());
                reqParam.setData(str);
            }

            /**
             * 服务是否鉴权
             */
            ServiceEntity serviceEntity = gatewayMapper.getService(reqParam.getServiceId());
            if(serviceEntity==null){
                rspParam.setCode(ResultCode.ER_1005);
                rspParam.setMsg(ResultCode.ER_1005_MSG);
            }
            if (serviceEntity.getIsCheck()) {
                ICheckService iCheckService = SpringContextUtil.getBean(serviceEntity.getServiceId()+"Impl", ICheckService.class);
                if (iCheckService.check(MapUtil.BeanToMap(reqParam))) {
                    rspParam.setCode(ResultCode.ER_1002);
                    rspParam.setMsg(ResultCode.ER_1002_MSG);
                    ctx.setResponseBody(JsonUtil.objToJson(rspParam));

                    return null;
                }
            }

            /**
             * 转发
             */
            final byte[] reqByte = reqParam.getData().getBytes();
            ctx.setSendZuulResponse(true);
            ctx.setRequest(new HttpServletRequestWrapper(request) {
                /**
                 * 重写请求参数
                 * @return
                 * @throws IOException
                 */
                @Override
                public ServletInputStream getInputStream() {
                    return new ServletInputStreamWrapper(reqByte);
                }

                @Override
                public int getContentLength() {
                    return reqByte.length;
                }

                @Override
                public long getContentLengthLong() {
                    return reqByte.length;
                }

                /**
                 * 重新uri
                 * @return
                 */
                @Override
                public String getRequestURI() {
                    return serviceEntity.getServiceUrl();
                }
            });


        } catch (Exception e) {
            LogUtil.logError(thread.get().getReqId(), "网关请求异常",  e);
            rspParam.setCode(ResultCode.ER_1003);
            rspParam.setMsg(ResultCode.ER_1003_MSG+e.getMessage());
            ctx.setResponseBody(JsonUtil.objToJson(rspParam));
            return null;
        } finally {
            if (!ResultCode.ER_1000.equals(rspParam.getCode())) {

                GatewayLog gatewayLog = new GatewayLog();
                gatewayLog.setReqId(reqParam.getReqId());
                gatewayLog.setReqParam(reqParam.getData());
                gatewayLog.setEncrypt(reqParam.isEncrypt());
                gatewayLog.setSign(reqParam.isSign());
                gatewayLog.setServiceId(reqParam.getServiceId());
                gatewayLog.setReqTime(reqParam.getReqTime());
                gatewayLog.setUserId(reqParam.getUserId());
                gatewayMapper.setGateway(gatewayLog);
            }

        }
//        } catch (NoSuchAlgorithmException e) {
//            LogUtil.logError(thread.get().getReqId(), "网关请求日志", "验签错误" + e);
//            rspParam.setCode(ResultCode.ER_1003);
//            rspParam.setMsg(ResultCode.ER_1003_MSG);
//            try {
//                ctx.setResponseBody(JsonUtil.ObjToJson(rspParam));
//            } catch (JsonProcessingException e1) {
//                e1.printStackTrace();
//            }
//
//            return null;
//        } catch (BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | InvalidKeyException e) {
//            LogUtil.logError(thread.get().getReqId(), "网关请求日志", "解密错误" + e);
//            rspParam.setCode(ResultCode.ER_1003);
//            rspParam.setMsg(ResultCode.ER_1003_MSG);
//            try {
//                ctx.setResponseBody(JsonUtil.ObjToJson(rspParam));
//            } catch (JsonProcessingException e1) {
//                e1.printStackTrace();
//            }
//
//            return null;
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//
//
//            return null;
//        }
        return null;
    }
}
