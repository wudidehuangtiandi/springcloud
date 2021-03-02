package com.zjgeport.invoicing.domain.models;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

/**
 * 船舶信息表
 * @author GC
 * Create at 2020-06-04 13:41
 */
@Entity
@Table(name = "SHIP_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ShipInfo {

    public ShipInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 船舶编号
     */
    @Column(name = "SHIP_NO")
    private String shipNo;

    /**
     * 中文船名
     */
    @Column(name = "SHIP_NAME_CNA")
    private String shipNameCna;

    /**
     * 英文船名
     */
    @Column(name = "SHIP_NAME_US")
    private String shipNameUs;

    /**
     * 船舶种类
     */
    @Column(name = "SHIP_TYPE")
    private String shipType;

    /**
     * MMSI
     */
    @Column(name = "SHIP_MMSI")
    private String shipMmsi;

    /**
     * IMO
     */
    @Column(name = "SHIP_IMO")
    private String shipImo;

    /**
     * 总长
     */
    @Column(name = "SHIP_LENGTH")
    private double shipLength;

    /**
     * 型宽
     */
    @Column(name = "SHIP_WIDTH")
    private double shipWidth;

    /**
     * 船高
     */
    @Column(name = "SHIP_HEIGHT")
    private double shipHeight;

    /**
     * 净重吨
     */
    @Column(name = "NET_TONNAGE")
    private double netTonnage;

    /**
     * 总吨位
     */
    @Column(name = "GROSS_TONNAGE")
    private double grossTonnage;

    /**
     * 载重吨
     */
    @Column(name = "DEADWEIGHT_TONNAGE")
    private double deadweightTonnage;

    /**
     * 运营证书许可证期限起始
     */
    @Column(name = "OPERATE_CERT_PERIOD_BEGIN")
    private Date operateCertPeriodBegin;

    /**
     * 运营证书许可证期限终止
     */
    @Column(name = "OPERATE_CERT_PERIOD_END")
    private Date operateCertPeriodEnd;

    /**
     * 年审合格证书期限起始
     */
    @Column(name = "ANNUAL_CERT_PERIOD_BEGIN")
    private Date annualCertPeriodBegin;

    /**
     * 年审合格证书期限终止
     */
    @Column(name = "ANNUAL_CERT_PERIOD_END")
    private Date annualCertPeriodEnd;

    /**
     * 所有权证书期限起始
     */
    @Column(name = "OWNERSHIP_CERT_PERIOD_BEGIN")
    private Date ownershipCertPeriodBegin;

    /**
     * 所有权证书期限终止
     */
    @Column(name = "OWNERSHIP_CERT_PERIOD_END")
    private Date ownershipCertPeriodEnd;

    /**
     * 船检证书期限起始
     */
    @Column(name = "INSPECTION_CERT_PERIOD_BEGIN")
    private Date inspectionCertPeriodBegin;

    /**
     * 船检证书期限终止
     */
    @Column(name = "INSPECTION_CERT_PERIOD_END")
    private Date inspectionCertPeriodEnd;

    /**
     * 适航证书期限终止
     */
    @Column(name = "SEAWORTHINESS_CERT_PERIOD_END")
    private Date seaworthinessCertPeriodEnd;

    /**
     * 国籍证书期限起始
     */
    @Column(name = "NATIONALITY_CERT_PERIOD_BEGIN")
    private Date nationalityCertPeriodBegin;

    /**
     * 国籍证书期限终止
     */
    @Column(name = "NATIONALITY_CERT_PERIOD_END")
    private Date nationalityCertPeriodEnd;

    /**
     * 运营证书许可证照片
     */
    @Column(name = "OPERATE_CERT_IMG")
    private String operateCertImg;

    /**
     * 年审合格证书照片
     */
    @Column(name = "ANNUAL_CERT_IMG")
    private String annualCertImg;

    /**
     * 所有权证书照片
     */
    @Column(name = "OWNERSHIP_CERT_IMG")
    private String ownershipCertImg;

    /**
     * 船检证书照片
     */
    @Column(name = "INSPECTION_CERT_IMG")
    private String inspectionCertImg;

    /**
     * 适航证书照片
     */
    @Column(name = "SEAWORTHINESS_CERT_IMG")
    private String seaworthinessCertImg;

    /**
     * 国籍证书照片
     */
    @Column(name = "NATIONALITY_CERT_IMG")
    private String nationalityCertImg;

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
     * 审核人
     */
    @Column(name = "CHECK_USER")
    private String checkUser;

    /**
     * 审核人ID
     */
    @Column(name = "CHECK_USER_ID")
    private String checkUserId;

    /**
     * 审核时间
     */
    @Column(name = "CHECK_DATE")
    private Date checkDate;

    /**
     * 审核意见
     */
    @Column(name = "CHECK_ADVICE")
    private String checkAdvice;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 适航证书期限起始
     */
    @Column(name = "SEAWORTHINESS_CERT_PERIOD_BGN")
    private Date seaworthinessCertPeriodBgn;
}