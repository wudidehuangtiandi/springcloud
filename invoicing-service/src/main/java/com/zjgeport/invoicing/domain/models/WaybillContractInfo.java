package com.zjgeport.invoicing.domain.models;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

/**
 * 运单合同信息主表
 * @author GC
 * Create at 2020-06-04 15:17
 */
@Entity
@Table(name = "WAYBILL_CONTRACT_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class WaybillContractInfo {

    public WaybillContractInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 发货方
     */
    @Column(name = "SEND_NAME")
    private String sendName;

    /**
     * 发货方联系人
     */
    @Column(name = "SEND_CNTACTOR")
    private String sendCntactor;

    /**
     * 发货方联系手机
     */
    @Column(name = "SEND_PHONE")
    private String sendPhone;

    /**
     * 发货方区域
     */
    @Column(name = "SEND_AREA")
    private String sendArea;

    /**
     * 发货方详细地址
     */
    @Column(name = "SEND_ADDRESS")
    private String sendAddress;

    /**
     * 收货方
     */
    @Column(name = "RECEIVE_NAME")
    private String receiveName;

    /**
     * 收货方联系人
     */
    @Column(name = "RECEIVE_CONTACTOR")
    private String receiveContactor;

    /**
     * 收货方联系手机
     */
    @Column(name = "RECEIVE_PHONE")
    private String receivePhone;

    /**
     * 收货方区域
     */
    @Column(name = "RECEIVE_AREA")
    private String receiveArea;

    /**
     * 收货方详细地址
     */
    @Column(name = "RECEIVE_ADDRESS")
    private String receiveAddress;

    /**
     * 合同编号
     */
    @Column(name = "TRANS_CONTRACT_NO")
    private String transContractNo;

    /**
     * 合同总额
     */
    @Column(name = "CONTRACT_TOTAL")
    private Integer contractTotal;

    /**
     * 开票金额（含税）
     */
    @Column(name = "INVOICED_AMOUNT")
    private Integer invoicedAmount;

    /**
     * 合同签订日期
     */
    @Column(name = "CONTRACT_SIGN_DATE")
    private Date contractSignDate;

    /**
     * 运输合同照片
     */
    @Column(name = "TRANSPORT_CONTRACT_IMG")
    private String transportContractImg;

    /**
     * 托运人编号
     */
    @Column(name = "CONSIGNOR_ID")
    private String consignorId;

    /**
     * 托运人名称
     */
    @Column(name = "CONSIGNOR_NAME")
    private String consignorName;

    /**
     * 托运人联系方式
     */
    @Column(name = "CONSIGNOR_PHONE")
    private String consignorPhone;

    /**
     * 承运人编号
     */
    @Column(name = "CARRIER_ID")
    private String carrierId;

    /**
     * 承运人名称
     */
    @Column(name = "CARRIER_NAME")
    private String carrierName;

    /**
     * 承运人联系方式
     */
    @Column(name = "CARRIER_PHONE")
    private String carrierPhone;

    /**
     * 支付方式
     */
    @Column(name = "PAY_METHOD")
    private String payMethod;

    /**
     * 支付渠道
     */
    @Column(name = "PAY_CHANNEL")
    private String payChannel;

    /**
     * 交易完成日期
     */
    @Column(name = "TRANS_COMPLETE_DATE")
    private Date transCompleteDate;

    /**
     * 收款银行卡号
     */
    @Column(name = "RECEIVE_CARD_NO")
    private String receiveCardNo;

    /**
     * 银行凭证照片
     */
    @Column(name = "BANK_VOUCHER_IMG")
    private String bankVoucherImg;

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
     * 审核状态 DSQ:待申请 DSH:待审核 YTG:已通过 WTG:未通过
     */
    @Column(name = "CHECK_STATE")
    private String checkState;

    /**
     * 审核意见
     */
    @Column(name = "CHECK_ADVICE")
    private String checkAdvice;

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
     * 运单来源
     */
    @Column(name = "WAYBILL_SOURCE")
    private String waybillSource;

    /**
     * 对应发票号
     */
    @Column(name = "RECEIPT_ID")
    private String receiptId;

    /**
     * 运单状态 1 正常 0 删除
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 收款行
     */
    @Column(name = "RECEIVE_CARD")
    private String receiveCard;

    /**
     * 运单类型
     */
    @Column(name = "WAYBILL_TYPE")
    private String waybillType;

    /**
     * 税率类型
     */
    @Column(name = "TAX_TYPE")
    private String taxType;
}