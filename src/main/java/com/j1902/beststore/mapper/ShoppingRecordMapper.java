package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.ShoppingRecord;
import com.j1902.beststore.pojo.ShoppingRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingRecordMapper {
    long countByExample(ShoppingRecordExample example);

    int deleteByExample(ShoppingRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingRecord record);

    int insertSelective(ShoppingRecord record);

    List<ShoppingRecord> selectByExample(ShoppingRecordExample example);

    ShoppingRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShoppingRecord record, @Param("example") ShoppingRecordExample example);

    int updateByExample(@Param("record") ShoppingRecord record, @Param("example") ShoppingRecordExample example);

    int updateByPrimaryKeySelective(ShoppingRecord record);

    int updateByPrimaryKey(ShoppingRecord record);
}