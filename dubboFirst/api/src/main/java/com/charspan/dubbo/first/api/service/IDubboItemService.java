package com.charspan.dubbo.first.api.service;

import com.charspan.dubbo.first.api.response.BaseResponse;

/**
 * 查询商品列表 dubbo协议调用
 */
public interface IDubboItemService {

    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo, Integer pageSize);

    BaseResponse listPageItemsParams(Integer pageNo, Integer pageSize, String search);

}