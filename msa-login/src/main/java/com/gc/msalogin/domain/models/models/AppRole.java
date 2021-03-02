package com.gc.msalogin.domain.models.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * 每个应用新建之后初始化一个管理员角色

角色复制
 * @author GC
 * Create at 2020-04-23 14:59
 */
@Entity
@Table(name = "APP_ROLE")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class AppRole {

    public AppRole(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 应用ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色代码
     */
    @Column(name = "ROLE_CODE")
    private String roleCode;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

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
}