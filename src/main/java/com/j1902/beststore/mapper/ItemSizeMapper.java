package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.ItemSize;
import com.j1902.beststore.pojo.ItemSizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemSizeMapper {
    long countByExample(ItemSizeExample example);

    int deleteByExample(ItemSizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemSize record);

    int insertSelective(ItemSize record);

    List<ItemSize> selectByExample(ItemSizeExample example);

    ItemSize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemSize record, @Param("example") ItemSizeExample example);

    int updateByExample(@Param("record") ItemSize record, @Param("example") ItemSizeExample example);

    int updateByPrimaryKeySelective(ItemSize record);

    int updateByPrimaryKey(ItemSize record);
}