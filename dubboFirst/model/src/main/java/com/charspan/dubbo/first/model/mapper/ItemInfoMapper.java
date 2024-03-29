package com.charspan.dubbo.first.model.mapper;

import com.charspan.dubbo.first.model.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

    ItemInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemInfo record);

    int updateByPrimaryKey(ItemInfo record);

    List<ItemInfo> selectAll();

    List<ItemInfo> selectAllByParams(@Param("search") String search);
}














