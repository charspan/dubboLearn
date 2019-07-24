package com.charspan.dubbo.first.server.controller;

import com.charspan.dubbo.first.api.enums.StatusCode;
import com.charspan.dubbo.first.api.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private static final Logger log= LoggerFactory.getLogger(BaseController.class);

    private static final String prefix="base";

    /**
     * 测试的hello world
     *  http://localhost:8093/dubboFirst/base/one?param=charspan
     * @param param
     * @return
     */
    @RequestMapping(value = prefix+"/one",method = RequestMethod.GET)
    public BaseResponse one(@RequestParam String param){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(param);

        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

}


























