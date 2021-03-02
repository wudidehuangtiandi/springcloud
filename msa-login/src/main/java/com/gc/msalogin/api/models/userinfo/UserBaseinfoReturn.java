package com.gc.msalogin.api.models.userinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserBaseinfoReturn {
    /**
     * 编号
     */
    @Schema(title = "ID")
    public String id;

    /**
     * 机构ID
     */
    @Schema(title = "机构ID")
    public String orgId;


    /**
     * 用户名
     */
    @Schema(title = "用户名")
    public String username;

    /**
     * 昵称
     */
    @Schema(title = "昵称")
    public String nickname;

    /**
     * 密码
     */
    @Schema(title = "密码")
    public String password;

    /**
     * 是否是管理员
     */
    @Schema(title = "是否是管理员")
    public String isAdmin;

    /**
     * 角色代码
     */
    @Schema(title = "角色代码")
    public String roleCode;
}
