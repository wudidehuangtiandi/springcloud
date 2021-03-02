package com.gc.msalogin.api.models.userinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * 用户基本信息
 * @author GC
 * Create at 2020-03-30 12:57
 */
@Getter@Setter
public class UserBaseinfoDto {

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
     * 姓名
     */
    @Schema(title = "姓名")
    public String realname;

    /**
     * 手机
     */
    @Schema(title = "手机")
    public String mobile;

    /**
     * 邮箱
     */
    @Schema(title = "邮箱")
    public String email;

    /**
     * 性别
     */
    @Schema(title = "性别")
    public String sex;

    /**
     * 职务
     */
    @Schema(title = "职务")
    public String job;

    /**
     * 积分
     */
    @Schema(title = "积分")
    public Integer credit;

    /**
     * 积分等级
     */
    @Schema(title = "积分等级")
    public Integer pointLevel;

    /**
     * 头像地址
     */
     @Schema(title = "头像地址")
    public String headAddress;

    /**
     * 手机认证状态
     */
    @Schema(title = "手机认证状态")
    public String phoneState;

    /**
     * 邮箱认证状态
    */
     @Schema(title = "邮箱认证状态")
    public String emailState;

    /**
     * 用户类型
     */
    @Schema(title = "用户类型")
    public String userType;

    /**
     * 是否是管理员
     */
    @Schema(title = "是否是管理员")
    public String isAdmin;

    /**
     * 密保问题
     */
    @Schema(title = "密保问题")
    public String protectQuestion;

    /**
     * 密保答案
     */
    @Schema(title = "密保答案")
    public String protectAnswer;

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

    /**
     * 账户状态
     */
    @Schema(title = "账户状态")
    public String state;

    /**
     * 挂靠企业状态
     */
    @Schema(title = "挂靠企业状态")
    public String findState;

    /**
     * 应用配置状态
     */
    @Schema(title = "应用配置状态")
    public String appCfgState;

    /**
     * 上次登陆IP
     */
    @Schema(title = "上次登陆IP")
    public String lastLoginIp;

    /**
     * 上次登陆时间
     */
    @Schema(title = "上次登陆时间")
    public OffsetDateTime lastLoginDate;

    /**
     * 组织架构ID
     */
    @Schema(title = "组织架构ID")
    public String struId;

    /**
     * 账户状态(企业)
     */
    @Schema(title = "账户状态(企业)")
    public String stateOrg;

    /**
     * 临时机构ID
     */
    @Schema(title = "临时机构ID")
    public String tempOrgId;

    /**
     * 证书信息
     */
    @Schema(title = "证书信息")
    public String certInfo;

    /**
     * UKEY唯一序列号
     */
    @Schema(title = "UKEY唯一序列号")
    public String keyNo;

    /**
     * 用户允许的登录方式(1:用户名密码,2:KEY,3:微信)
     */
    @Schema(title = "用户允许的登录方式(1:用户名密码,2:KEY,3:微信)")
    public String loginMode;

    /**
     * 移动端token
     */
    @Schema(title = "移动端token")
    public String token;

    /**
     * 
     */
    @Schema(title = "老密码")
    public String oldPassword;
}