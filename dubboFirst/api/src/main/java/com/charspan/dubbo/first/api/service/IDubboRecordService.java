package com.charspan.dubbo.first.api.service;

import com.charspan.dubbo.first.api.request.PushOrderDto;
import com.charspan.dubbo.first.api.response.BaseResponse;

/**
 * 用户下单 http rest api协议
 */
public interface IDubboRecordService {

    BaseResponse pushOrder(PushOrderDto dto);

}
