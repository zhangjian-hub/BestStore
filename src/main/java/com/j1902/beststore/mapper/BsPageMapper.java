package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsPage;
import com.j1902.beststore.pojo.BsPageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsPageMapper {
    long countByExample(BsPageExample example);

    int deleteByExample(BsPageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsPage record);

    int insertSelective(BsPage record);

    List<BsPage> selectByExample(BsPageExample example);

    BsPage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsPage record, @Param("example") BsPageExample example);

    int updateByExample(@Param("record") BsPage record, @Param("example") BsPageExample example);

    int updateByPrimaryKeySelective(BsPage record);

    int updateByPrimaryKey(BsPage record);
}