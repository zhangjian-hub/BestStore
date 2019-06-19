package com.j1902.beststore.mapper;

import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsShoppingCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsShoppingCartMapper {
    long countByExample(BsShoppingCartExample example);

    int deleteByExample(BsShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsShoppingCart record);

    int insertSelective(BsShoppingCart record);

    List<BsShoppingCart> selectByExample(BsShoppingCartExample example);

    BsShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsShoppingCart record, @Param("example") BsShoppingCartExample example);

    int updateByExample(@Param("record") BsShoppingCart record, @Param("example") BsShoppingCartExample example);

    int updateByPrimaryKeySelective(BsShoppingCart record);

    int updateByPrimaryKey(BsShoppingCart record);
}