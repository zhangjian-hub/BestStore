package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsOrderForm;
import com.j1902.beststore.pojo.BsOrderFormExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BsOrderFormMapper {
    long countByExample(BsOrderFormExample example);

    int deleteByExample(BsOrderFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsOrderForm record);

    int insertSelective(BsOrderForm record);

    List<BsOrderForm> selectByExample(BsOrderFormExample example);

    BsOrderForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsOrderForm record, @Param("example") BsOrderFormExample example);

    int updateByExample(@Param("record") BsOrderForm record, @Param("example") BsOrderFormExample example);

    int updateByPrimaryKeySelective(BsOrderForm record);

    int updateByPrimaryKey(BsOrderForm record);
}