package com.example.msauserinformationandauthority.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * 用户基本信息
 * @author GC
 * Create at 2020-03-30 12:57
 */
@Entity
@Table(name = "USER_BASEINFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserBaseinfo {



    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 机构ID
     */
    @Column(name = "ORG_ID")
    private String orgId;

    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 昵称
     */
    @Column(name = "NICKNAME")
    private String nickname;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 姓名
     */
    @Column(name = "REALNAME")
    private String realname;

    /**
     * 手机
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private String sex;

    /**
     * 职务
     */
    @Column(name = "JOB")
    private String job;

    /**
     * 积分
     */
    @Column(name = "CREDIT")
    private Integer credit;

    /**
     * 积分等级
     */
    @Column(name = "POINT_LEVEL")
    private Integer pointLevel;

    /**
     * 头像地址
     */
    @Column(name = "HEAD_ADDRESS")
    private String headAddress;

    /**
     * 手机认证状态
     */
    @Column(name = "PHONE_STATE")
    private String phoneState;

    /**
     * 邮箱认证状态
     */
    @Column(name = "EMAIL_STATE")
    private String emailState;

    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private String userType;

    /**
     * 是否是管理员
     */
    @Column(name = "IS_ADMIN")
    private String isAdmin;

    /**
     * 密保问题
     */
    @Column(name = "PROTECT_QUESTION")
    private String protectQuestion;

    /**
     * 密保答案
     */
    @Column(name = "PROTECT_ANSWER")
    private String protectAnswer;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 创建人ID
     */
    @Column(name = "CREATE_USER_ID")
    private String createUserId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private OffsetDateTime createDate;

    /**
     * 修改人
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 修改人ID
     */
    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_DATE")
    private OffsetDateTime updateDate;

    /**
     * 账户状态
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 挂靠企业状态
     */
    @Column(name = "FIND_STATE")
    private String findState;

    /**
     * 应用配置状态
     */
    @Column(name = "APP_CFG_STATE")
    private String appCfgState;

    /**
     * 上次登陆IP
     */
    @Column(name = "LAST_LOGIN_IP")
    private String lastLoginIp;

    /**
     * 上次登陆时间
     */
    @Column(name = "LAST_LOGIN_DATE")
    private OffsetDateTime lastLoginDate;

    /**
     * 组织架构ID
     */
    @Column(name = "STRU_ID")
    private String struId;

    /**
     * 账户状态(企业)
     */
    @Column(name = "STATE_ORG")
    private String stateOrg;

    /**
     * 临时机构ID
     */
    @Column(name = "TEMP_ORG_ID")
    private String tempOrgId;

    /**
     * 证书信息
     */
    @Column(name = "CERT_INFO")
    private String certInfo;

    /**
     * UKEY唯一序列号
     */
    @Column(name = "KEY_NO")
    private String keyNo;

    /**
     * 用户允许的登录方式(1:用户名密码,2:KEY,3:微信)
     */
    @Column(name = "LOGIN_MODE")
    private String loginMode;

    /**
     * 移动端token
     */
    @Column(name = "TOKEN")
    private String token;

    /**
     * 
     */
    @Column(name = "OLD_PASSWORD")
    private String oldPassword;
}