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
 * 信息分开

确认字段

单位人员维护

挂靠权限控制

机构类型以ID:ID的形式保存
 * @author GC
 * Create at 2020-04-23 15:00
 */
@Entity
@Table(name = "ORG_BASEINFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class OrgBaseinfo {

    public OrgBaseinfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 中文名称
     */
    @Column(name = "ORG_NAME_CN")
    private String orgNameCn;

    /**
     * 中文简称
     */
    @Column(name = "ORG_NAME_SCN")
    private String orgNameScn;

    /**
     * 组织机构代码
     */
    @Column(name = "ORG_CODE")
    private String orgCode;

    /**
     * 营业执照号
     */
    @Column(name = "BUS_LIC_CODE")
    private String busLicCode;

    /**
     * 税务登记号
     */
    @Column(name = "TAX_CODE")
    private String taxCode;

    /**
     * 中文地址
     */
    @Column(name = "ADDRESS_CN")
    private String addressCn;

    /**
     * 机构性质
     */
    @Column(name = "ORG_PROPERTY")
    private String orgProperty;

    /**
     * 机构类型
     */
    @Column(name = "ORG_TYPE")
    private String orgType;

    /**
     * 法人姓名
     */
    @Column(name = "LEGAL_NAME")
    private String legalName;

    /**
     * 法人电话
     */
    @Column(name = "LEGAL_PHONE")
    private String legalPhone;

    /**
     * 证件类型
     */
    @Column(name = "CERT_TYPE")
    private String certType;

    /**
     * 证件号
     */
    @Column(name = "CERT_NO")
    private String certNo;

    /**
     * 所在省
     */
    @Column(name = "SHENG")
    private String sheng;

    /**
     * 所在市
     */
    @Column(name = "SHI")
    private String shi;

    /**
     * 所在区县
     */
    @Column(name = "QUXIAN")
    private String quxian;

    /**
     * 行政区域代码
     */
    @Column(name = "AREA_CODE")
    private String areaCode;

    /**
     * 企业LOGO
     */
    @Column(name = "LOGO")
    private String logo;

    /**
     * 排序号
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * 注册方式
     */
    @Column(name = "REG_TYPE")
    private String regType;

    /**
     * 审核状态
     */
    @Column(name = "CHECK_STATE")
    private String checkState;

    /**
     * 审核意见
     */
    @Column(name = "CHECK_ADV")
    private String checkAdv;

    /**
     * 审核时间
     */
    @Column(name = "CHECK_SUCC_TIME")
    private OffsetDateTime checkSuccTime;

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

    /**
     * 区域名称
     */
    @Column(name = "AREA_NAME")
    private String areaName;

    /**
     * 账户状态
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 企业简称编码
     */
    @Column(name = "ORG_SNAME_CODE")
    private String orgSnameCode;

    /**
     * 电子口岸企业编码
     */
    @Column(name = "CORP_CODE")
    private String corpCode;
}