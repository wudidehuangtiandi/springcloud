package com.zjgeport.invoicing.domain.models;

import lombok.*;
import javax.persistence.*;

import java.time.*;
import java.util.Date;

/**
 * 其它开户行信息
 * @author GC
 * Create at 2020-06-04 14:57
 */
@Entity
@Table(name = "CONSIGNOR_OPENBANK")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ConsignorOpenbank {

    public ConsignorOpenbank(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 对应的托运人/承运人编号
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 开户名
     */
    @Column(name = "OPENING_NAME")
    private String openingName;

    /**
     * 开户行
     */
    @Column(name = "OPENING_BANK")
    private String openingBank;

    /**
     * 开户账号
     */
    @Column(name = "OPENING_ACCOUNT")
    private String openingAccount;

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
    private Date createDate;

    /**
     * 创建机构
     */
    @Column(name = "CREATE_ORG")
    private String createOrg;

    /**
     * 创建机构ID
     */
    @Column(name = "CREATE_ORG_ID")
    private String createOrgId;

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
    private Date updateDate;

    /**
     * 修改人机构
     */
    @Column(name = "UPDATE_ORG")
    private String updateOrg;

    /**
     * 修改人机构ID
     */
    @Column(name = "UPDATE_ORG_ID")
    private String updateOrgId;

    /**
     * 所属关系
     */
    @Column(name = "RELATIONS")
    private String relations;
}