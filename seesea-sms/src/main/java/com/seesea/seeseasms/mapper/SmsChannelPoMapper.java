package com.seesea.seeseasms.mapper;

import com.seesea.seeseasms.model.po.SmsChannelPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SmsChannelPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sms_channel
     *
     * @mbg.generated Thu Oct 25 23:23:56 CST 2018
     */
    int deleteByPrimaryKey(String smsChannelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sms_channel
     *
     * @mbg.generated Thu Oct 25 23:23:56 CST 2018
     */
    int insert(SmsChannelPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sms_channel
     *
     * @mbg.generated Thu Oct 25 23:23:56 CST 2018
     */
    SmsChannelPo selectByPrimaryKey(String smsChannelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sms_channel
     *
     * @mbg.generated Thu Oct 25 23:23:56 CST 2018
     */
    List<SmsChannelPo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sms_channel
     *
     * @mbg.generated Thu Oct 25 23:23:56 CST 2018
     */
    int updateByPrimaryKey(SmsChannelPo record);

    @Select("select * from tb_sms_channel where remainder = (select min(remainder) from tb_sms_channel where status = '1')")
    List<SmsChannelPo> selectACanUseChannel();

    /**
     * 发一次减去一条
     * @return
     */
    @Update("UPDATE tb_sms_channel set remainder = remainder-1")
    int updateChannlRemainder();
}