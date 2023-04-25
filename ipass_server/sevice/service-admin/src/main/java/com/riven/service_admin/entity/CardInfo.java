package com.riven.service_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * </p>
 * @author riven
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CardInfo对象", description="")
public class CardInfo implements Serializable {

//    @TableId(value = "card_id", type = IdType.ID_WORKER_STR)
    private Integer cardId;

    private String cardNumber;

    private Integer state;

    private String userId;
    private String receiveId;
    private String adminId;

    @TableLogic
    private Boolean isDeleted;

    private Date userCtime;
    private Date userMtime;


}
