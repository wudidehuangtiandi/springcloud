package com.example.msauserinformationandauthority.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.*;


/**
 * 每个应用新建之后初始化一个管理员角色

角色复制
 * @author GC
 * Create at 2020-04-23 14:59
 */
@Getter@Setter
public class AppRoleDto {

    /**
     * 编号
     */
    @Schema(title = "编号")
    public String id;

    /**
     * 应用ID
     */
    @Schema(title = "应用ID")
    public String appId;

    /**
     * 角色名称
     */
    @Schema(title = "角色名称")
    public String roleName;

    /**
     * 角色代码
     */
    @Schema(title = "角色代码")
    public String roleCode;

    /**
     * 备注
     */
    @Schema(title = "备注")
    public String remark;

    /**
     * 创建人
     */
    @Schema(title = "创建人")
    public String createUser;

    /**
     * 创建人ID
     */
    @Schema(title = "创建人ID")
    public String createUserId;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    public OffsetDateTime createDate;

    /**
     * 修改人
     */
    @Schema(title = "修改人")
    public String updateUser;

    /**
     * 修改人ID
     */
    @Schema(title = "修改人ID")
    public String updateUserId;

    /**
     * 修改时间
     */
    @Schema(title = "修改时间")
    public OffsetDateTime updateDate;
}