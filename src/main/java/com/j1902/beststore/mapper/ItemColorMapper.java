package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.ItemColor;
import com.j1902.beststore.pojo.ItemColorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemColorMapper {
    long countByExample(ItemColorExample example);

    int deleteByExample(ItemColorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemColor record);

    int insertSelective(ItemColor record);

    List<ItemColor> selectByExample(ItemColorExample example);

    ItemColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemColor record, @Param("example") ItemColorExample example);

    int updateByExample(@Param("record") ItemColor record, @Param("example") ItemColorExample example);

    int updateByPrimaryKeySelective(ItemColor record);

    int updateByPrimaryKey(ItemColor record);
}