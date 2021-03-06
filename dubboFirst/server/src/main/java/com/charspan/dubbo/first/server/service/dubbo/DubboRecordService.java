package com.charspan.dubbo.first.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

import com.charspan.dubbo.first.api.enums.StatusCode;
import com.charspan.dubbo.first.api.request.PushOrderDto;
import com.charspan.dubbo.first.api.response.BaseResponse;
import com.charspan.dubbo.first.api.service.IDubboRecordService;
import com.charspan.dubbo.first.model.entity.ItemInfo;
import com.charspan.dubbo.first.model.entity.OrderRecord;
import com.charspan.dubbo.first.model.mapper.ItemInfoMapper;
import com.charspan.dubbo.first.model.mapper.OrderRecordMapper;

import com.google.common.base.Strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

// 其实只用了rest协议
// http://localhost:9013/v1/record/push
/*
{
	"itemId":1,
	"total":2,
	"customerName":"charspan"
}
 */
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 30000)
@Path("record")
public class DubboRecordService implements IDubboRecordService {

    private static final Logger log = LoggerFactory.getLogger(DubboRecordService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    /**
     * 下单服务
     *
     * @param dto
     */
    @Path("push")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse pushOrder(PushOrderDto dto) {
        if (dto.getItemId() == null || dto.getItemId() <= 0 || Strings.isNullOrEmpty(dto.getCustomerName())
                || dto.getTotal() == null) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        log.info("请求过来的参数：{} ", dto);
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //TODO:实际的业务逻辑

            //TODO:校验商品信息是否存在
            ItemInfo info = itemInfoMapper.selectByPrimaryKey(dto.getItemId());
            if (info == null) {
                return new BaseResponse(StatusCode.ItemNotExist);
            }

            //TODO:库存服务-校验....

            //TODO:客户中心服务-校验....

            //TODO:订单服务-下单
            OrderRecord entity = new OrderRecord();
            BeanUtils.copyProperties(dto, entity);
            entity.setOrderTime(new Date());
            orderRecordMapper.insertSelective(entity);

            response.setData(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

}
























