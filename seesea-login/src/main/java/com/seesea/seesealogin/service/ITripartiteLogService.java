package com.seesea.seesealogin.service;

import com.seesea.seesealogin.model.vo.TripartiteVo;

import java.util.Map;

public interface ITripartiteLogService {

    Map<String,Object> tripartiteLog(TripartiteVo tripartiteVo);
}
