package com.j1902.beststore.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemPropertyMapper {
    long countByExample(ItemPropertyExample example);

    int deleteByExample(ItemPropertyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemProperty record);

    int insertSelective(ItemProperty record);

    List<ItemProperty> selectByExample(ItemPropertyExample example);

    ItemProperty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemProperty record, @Param("example") ItemPropertyExample example);

    int updateByExample(@Param("record") ItemProperty record, @Param("example") ItemPropertyExample example);

    int updateByPrimaryKeySelective(ItemProperty record);

    int updateByPrimaryKey(ItemProperty record);
}