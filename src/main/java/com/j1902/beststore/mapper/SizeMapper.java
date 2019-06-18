package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.Size;
import com.j1902.beststore.pojo.SizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SizeMapper {
    long countByExample(SizeExample example);

    int deleteByExample(SizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Size record);

    int insertSelective(Size record);

    List<Size> selectByExample(SizeExample example);

    Size selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByExample(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByPrimaryKeySelective(Size record);

    int updateByPrimaryKey(Size record);
}