package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsEmail;
import com.j1902.beststore.pojo.BsEmailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsEmailMapper {
    long countByExample(BsEmailExample example);

    int deleteByExample(BsEmailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsEmail record);

    int insertSelective(BsEmail record);

    List<BsEmail> selectByExampleWithBLOBs(BsEmailExample example);

    List<BsEmail> selectByExample(BsEmailExample example);

    BsEmail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsEmail record, @Param("example") BsEmailExample example);

    int updateByExampleWithBLOBs(@Param("record") BsEmail record, @Param("example") BsEmailExample example);

    int updateByExample(@Param("record") BsEmail record, @Param("example") BsEmailExample example);

    int updateByPrimaryKeySelective(BsEmail record);

    int updateByPrimaryKeyWithBLOBs(BsEmail record);

    int updateByPrimaryKey(BsEmail record);
}