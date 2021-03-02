package com.gc.msalogin.api.models.userinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class UserBaseinfoCheck {

    /**
     * 用户名
     */
    @Schema(title = "用户名")
    public String username;

    /**
     * 密码
     */
    @Schema(title = "密码")
    public String password;
}
