package com.zjgeport.invoicing.domain.models;


import lombok.*;


import javax.persistence.*;
import java.util.Date;

/**
 * 承运人基础信息表
 * @author GC
 * Create at 2020-06-03 15:30
 */
@Entity
@Table(name = "CARRIER_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class CarrierInfo {

    public CarrierInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 承运人名称
     */
    @Column(name = "ENTERPRISE_NAME")
    private String enterpriseName;

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 联系人手机/电话
     */
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;

    /**
     * 统一社会信用代码
     */
    @Column(name = "SOCIAL_CREDIT_CODE")
    private String socialCreditCode;

    /**
     * 法人
     */
    @Column(name = "LEGAL_PERSON")
    private String legalPerson;

    /**
     * 所在区域
     */
    @Column(name = "LOCATION")
    private String location;

    /**
     * 详细地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 营业执照期限起
     */

    @Column(name = "BUSINESS_LICENSE_PERIOD_BEGIN")
    
    private Date businessLicensePeriodBegin;

    /**
     * 营业执照期限终
     */
     
    @Column(name = "BUSINESS_LICENSE_PERIOD_END")
    private Date businessLicensePeriodEnd;

    /**
     * 营业执照照片
     */
    @Column(name = "BUSINESS_LICENSE_IMG")
    private String businessLicenseImg;

    /**
     * 道路运输许可证号
     */
    @Column(name = "TRANSPORT_PERMIT_NUMBER")
    private String transportPermitNumber;

    /**
     * 道路运输许可证有效期始
     */
     
    @Column(name = "TRANSPORT_PERMIT_PERIOD_BEGIN")
    private Date transportPermitPeriodBegin;

    /**
     * 道路运输许可证有效期终
     */
     
    @Column(name = "TRANSPORT_PERMIT_PERIOD_END")
    private Date transportPermitPeriodEnd;

    /**
     * 道路运输许可证照片
     */
    @Column(name = "TRANSPORT_PERMIT_IMG")
    private String transportPermitImg;

    /**
     * 身份证号码
     */
    @Column(name = "CARRIER_ID_NUMBER")
    private String carrierIdNumber;

    /**
     * 身份证有效期始
     */
     
    @Column(name = "ID_CARD_PERIOND_BEGIN")
    private Date idCardPeriondBegin;

    /**
     * 身份证有效期终
     */
     
    @Column(name = "ID_CARD_PERIOND_END")
    private Date idCardPeriondEnd;

    /**
     * 身份证正面照片
     */
    @Column(name = "ID_CARD_OPPO_IMG")
    private String idCardOppoImg;

    /**
     * 身份证反面照片
     */
    @Column(name = "ID_CARD_BG_IMG")
    private String idCardBgImg;

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
     * 账号登陆密码
     */
    @Column(name = "ACC_PWD")
    private String accPwd;

    /**
     * 承运人类型
     */
    @Column(name = "CARRIER_TYPE")
    private String carrierType;

    /**
     * 临时纳税号
     */
    @Column(name = "TEMP_TAX_CODE")
    private String tempTaxCode;

    /**
     * 临时纳税号起始日期
     */
     
    @Column(name = "TEMP_TAX_CODE_BEG")
    private Date tempTaxCodeBeg;

    /**
     * 临时纳税号终止日期
     */
     
    @Column(name = "TEMP_TAX_CODE_END")
    private Date tempTaxCodeEnd;

    /**
     * 默认匹配的载具ID
     */
    @Column(name = "VECH_ID")
    private String vechId;

    /**
     * 默认匹配的载具类型
     */
    @Column(name = "VECH_TYPE")
    private String vechType;





}