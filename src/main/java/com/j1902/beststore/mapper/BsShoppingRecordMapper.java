package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsShoppingRecord;
import com.j1902.beststore.pojo.BsShoppingRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsShoppingRecordMapper {
    long countByExample(BsShoppingRecordExample example);

    int deleteByExample(BsShoppingRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsShoppingRecord record);

    int insertSelective(BsShoppingRecord record);

    List<BsShoppingRecord> selectByExample(BsShoppingRecordExample example);

    BsShoppingRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsShoppingRecord record, @Param("example") BsShoppingRecordExample example);

    int updateByExample(@Param("record") BsShoppingRecord record, @Param("example") BsShoppingRecordExample example);

    int updateByPrimaryKeySelective(BsShoppingRecord record);

    int updateByPrimaryKey(BsShoppingRecord record);
}