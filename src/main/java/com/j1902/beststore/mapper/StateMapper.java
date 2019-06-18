package com.j1902.beststore.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StateMapper {
    long countByExample(StateExample example);

    int deleteByExample(StateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(State record);

    int insertSelective(State record);

    List<State> selectByExample(StateExample example);

    State selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") State record, @Param("example") StateExample example);

    int updateByExample(@Param("record") State record, @Param("example") StateExample example);

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);
}