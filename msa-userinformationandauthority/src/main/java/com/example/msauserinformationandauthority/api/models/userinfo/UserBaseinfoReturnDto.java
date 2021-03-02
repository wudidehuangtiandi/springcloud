package com.example.msauserinformationandauthority.api.models.userinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter
@NoArgsConstructor
public class UserBaseinfoReturnDto {
    /**
     * 编号
     */
    @Schema(title = "ID")
    public String id;

    /**
     * 机构ID
     */
    @Schema(name = "机构ID")
    private String orgId;

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
     * 是否是管理员
     */
    @Schema(title = "是否是管理员")
    public String isAdmin;

    /**
     * 角色代码
     */
    @Schema(title = "角色代码")
    public String roleCode;

    public UserBaseinfoReturnDto(String id, String orgId, String username, String nickname, String isAdmin) {
        this.id = id;
        this.orgId = orgId;
        this.username = username;
        this.nickname = nickname;
        this.isAdmin = isAdmin;
    }
}
