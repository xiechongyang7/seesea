package com.seesea.seeseagateway.mapper;

import com.seesea.seeseagateway.entity.GatewayLog;
import com.seesea.seeseagateway.entity.RspParam;
import com.seesea.seeseagateway.entity.ServiceEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GatewayMapper {

    /**
     * 查找流水号
     * @param reqId
     * @return
     */
    @Select("select count(req_id) from tb_gateway_log where req_id = #{reqId}")
    int getReqId(@Param("reqId") String reqId);

    /**
     * 查找
     * @param serviceId
     * @return
     */
    @Select("select * from tb_service where service_id = #{serviceId}")
    ServiceEntity getService(@Param("serviceId") String serviceId);

    /**
     * 插入日志
     * @param gatewayLog
     * @return
     */
    @Insert("insert into tb_gateway_log (req_id,req_param,isEncrypt,isSign,service_id,req_time,user_id) values (#{reqId},#{reqParam},#{isEncrypt},#{isSign},#{serviceId},#{reqTime},#{userId})")
    int setGateway(GatewayLog gatewayLog);


    /**
     * 修改日志
     * @param rspParam
     * @return
     */
    @Insert("update tb_gateway_log set rsp_msg = #{msg},rsp_param = #{data} , rsp_time = #{rspTime}, rsp_code = #{code} " +
            "where req_id = #{reqId}")
    int putGateway(RspParam rspParam);
}
