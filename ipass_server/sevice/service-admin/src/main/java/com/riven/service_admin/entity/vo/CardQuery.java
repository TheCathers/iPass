package com.riven.service_admin.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CardQuery {
    @ApiModelProperty(value = "卡号，模糊查询")
    private String cardNumber;
    @ApiModelProperty(value = "状态 0未使用，1使用中，2已注销")
    private Integer state;
    @ApiModelProperty(value = "持卡人id")
    private String userId;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "领用人id")
    private String receiveId;
}
