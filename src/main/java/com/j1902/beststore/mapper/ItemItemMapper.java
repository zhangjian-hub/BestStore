package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.ItemItem;
import com.j1902.beststore.pojo.ItemItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemItemMapper {
    long countByExample(ItemItemExample example);

    int deleteByExample(ItemItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemItem record);

    int insertSelective(ItemItem record);

    List<ItemItem> selectByExample(ItemItemExample example);

    ItemItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemItem record, @Param("example") ItemItemExample example);

    int updateByExample(@Param("record") ItemItem record, @Param("example") ItemItemExample example);

    int updateByPrimaryKeySelective(ItemItem record);

    int updateByPrimaryKey(ItemItem record);
}