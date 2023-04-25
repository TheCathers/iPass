package com.riven.service_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author riven
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private Integer userId;

    private String userName;

    private String userNative;

    private Integer cardId;

    private String userIdentify;

    private String userAddress;

    private String userNumber;

    private String userSex;

    private Integer userAge;

    private String userWeek;

    private Integer userState;

    private Date userCtime;

    private Date userMtime;


}
