package com.seesea.seeseasms.service;

import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseasms.model.bo.ChannelResultBo;
import com.seesea.seeseasms.model.po.SmsChannelPo;
import com.seesea.seeseasms.model.vo.SendSmsVo;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/25 上午 12:12
 * @Author xiechongyang
 */
public interface ISmsChannel {

    /**
     * 校验类
     * @param sendSmsVo
     * @param smsChannelPo
     * @return
     */
    ChannelResultBo send(SendSmsVo sendSmsVo, SmsChannelPo smsChannelPo) throws BizException;

    /**
     * 通知类
     * @param sendSmsVo
     * @param smsChannelPo
     * @return
     */
    ChannelResultBo notice(SendSmsVo sendSmsVo, SmsChannelPo smsChannelPo) throws BizException;

    /**
     * 语音类
     * @param sendSmsVo
     * @param smsChannelPo
     * @return
     * @throws BizException
     */
    ChannelResultBo voice(SendSmsVo sendSmsVo, SmsChannelPo smsChannelPo) throws BizException;

}
