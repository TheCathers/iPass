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
@ApiModel(value="AdminInfo对象", description="")
public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "admin_id", type = IdType.ID_WORKER_STR)
    private Integer adminId;

    private Integer roleId;

    private Integer sectionId;

    private String adminName;

    private String adminAccount;

    private String adminPassword;

    private Integer adminState;

    private Date adminCtime;

    private Date adminMtime;


}
