package com.seesea.seesealogin.service;

import com.seesea.seesealogin.model.vo.TripartiteVo;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/5 下午 10:42
 * @Author xiechongyang
 */
public interface ITripartiteService {

    Map<String,Object> tripartiteLog(TripartiteVo tripartiteVo);

    Map<String,Object> getInfo();
}
