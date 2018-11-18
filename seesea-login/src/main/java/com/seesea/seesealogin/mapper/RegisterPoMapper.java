package com.seesea.seesealogin.mapper;

import com.seesea.seesealogin.model.po.RegisterPo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_register
     *
     * @mbg.generated Tue Oct 30 21:18:09 CST 2018
     */
    int deleteByPrimaryKey(@Param("registerAcct") String registerAcct, @Param("status") String status);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_register
     *
     * @mbg.generated Tue Oct 30 21:18:09 CST 2018
     */
    int insert(RegisterPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_register
     *
     * @mbg.generated Tue Oct 30 21:18:09 CST 2018
     */
    RegisterPo selectByPrimaryKey(@Param("registerAcct") String registerAcct, @Param("status") String status);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_register
     *
     * @mbg.generated Tue Oct 30 21:18:09 CST 2018
     */
    List<RegisterPo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_register
     *
     * @mbg.generated Tue Oct 30 21:18:09 CST 2018
     */
    int updateByPrimaryKey(RegisterPo record);
}