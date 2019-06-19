package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsItemStock;
import com.j1902.beststore.pojo.BsItemStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsItemStockMapper {
    long countByExample(BsItemStockExample example);

    int deleteByExample(BsItemStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsItemStock record);

    int insertSelective(BsItemStock record);

    List<BsItemStock> selectByExample(BsItemStockExample example);

    BsItemStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsItemStock record, @Param("example") BsItemStockExample example);

    int updateByExample(@Param("record") BsItemStock record, @Param("example") BsItemStockExample example);

    int updateByPrimaryKeySelective(BsItemStock record);

    int updateByPrimaryKey(BsItemStock record);
}