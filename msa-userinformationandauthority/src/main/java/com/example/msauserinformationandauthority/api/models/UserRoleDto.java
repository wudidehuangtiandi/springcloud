package com.example.msauserinformationandauthority.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户角色表
 * @author GC
 * Create at 2020-04-23 14:58
 */
@Getter@Setter
public class UserRoleDto {

    /**
     * 编号
     */
    @Schema(title = "ID")
    public String id;

    /**
     * 用户ID
     */
    @Schema(title = "用户ID")
    public String userId;

    /**
     * 应用ID
     */
    @Schema(title = "应用ID")
    public String appId;

    /**
     * 角色ID
     */
    @Schema(title = "角色ID")
    public String roleId;

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
     * 状态
     */
    @Schema(title = "状态")
    public String state;
}