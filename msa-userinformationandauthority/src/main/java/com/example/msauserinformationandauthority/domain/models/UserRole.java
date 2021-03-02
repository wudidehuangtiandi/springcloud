package com.example.msauserinformationandauthority.domain.models;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

/**
 * 用户角色表
 * @author GC
 * Create at 2020-04-23 14:58
 */
@Entity
@Table(name = "USER_ROLE")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserRole {

    public UserRole(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 应用ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

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
     * 状态
     */
    @Column(name = "STATE")
    private String state;
}