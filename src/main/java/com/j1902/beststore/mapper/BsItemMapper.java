package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsItemExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BsItemMapper {
    long countByExample(BsItemExample example);

    int deleteByExample(BsItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsItem record);

    int insertSelective(BsItem record);

    List<BsItem> selectByExample(BsItemExample example);

    BsItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsItem record, @Param("example") BsItemExample example);

    int updateByExample(@Param("record") BsItem record, @Param("example") BsItemExample example);

    int updateByPrimaryKeySelective(BsItem record);

    int updateByPrimaryKey(BsItem record);

    List<BsItem> selectAllGroupByName(BsItem bsItem);

    List<BsItem> selectAll();
}