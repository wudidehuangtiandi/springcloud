package com.zjgeport.invoicing.domain.models;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

/**
 * 发票详细信息
 * @author GC
 * Create at 2020-06-05 09:02
 */
@Entity
@Table(name = "RECEIPT_SINGLE_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ReceiptSingleInfo {

    public ReceiptSingleInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 申请开票批次号
     */
    @Column(name = "BATCH_NO")
    private String batchNo;

    /**
     * 所属批次ID
     */
    @Column(name = "BATCH_ID")
    private String batchId;

    /**
     * 序号
     */
    @Column(name = "BATCH_SEQ")
    private double batchSeq;

    /**
     * 收票方编号
     */
    @Column(name = "CONGINOR_ID")
    private String conginorId;

    /**
     * 收票方名称
     */
    @Column(name = "CONSIGNOR_NAME")
    private String consignorName;

    /**
     * 总票面额（含税）
     */
    @Column(name = "TOTAL_MONEY_INTAX")
    private double totalMoneyIntax;

    /**
     * 合同费率(%)
     */
    @Column(name = "CONTRACT_RATE")
    private double contractRate;

    /**
     * 应缴平台税款
     */
    @Column(name = "TAX_PAYABLE")
    private double taxPayable;

    /**
     * 发票领取方式
     */
    @Column(name = "RECEIPT_METHOD")
    private String receiptMethod;

    /**
     * 收件人
     */
    @Column(name = "RECEIVER")
    private String receiver;

    /**
     * 收件电话
     */
    @Column(name = "RECEIVE_PHONE")
    private String receivePhone;

    /**
     * 收件地址
     */
    @Column(name = "RECEIVE_ADDRESS")
    private String receiveAddress;

    /**
     * 发票发放状态
     */
    @Column(name = "RECEIPT_SEND_STATE")
    private String receiptSendState;

    /**
     * 发票照片存档
     */
    @Column(name = "RECEIPT_IMG")
    private String receiptImg;

    /**
     * 开票状态
     */
    @Column(name = "INVOICE_STATE")
    private String invoiceState;

    /**
     * 核销状态
     */
    @Column(name = "WRITE_OFF_SATE")
    private String writeOffSate;

    /**
     * 核销人
     */
    @Column(name = "WRITE_OFF_USER")
    private String writeOffUser;

    /**
     * 核销人ID
     */
    @Column(name = "WRITE_OFF_USER_ID")
    private String writeOffUserId;

    /**
     * 核销时间
     */
    @Column(name = "WRITE_OFF_DATE")
    private Date writeOffDate;

    /**
     * 平台缴纳税款
     */
    @Column(name = "PLATFORM_PAY_MONEY")
    private double platformPayMoney;

    /**
     * 财政返款
     */
    @Column(name = "GET_FROM_FINANCE")
    private double getFromFinance;

    /**
     * 利润
     */
    @Column(name = "PROFIT")
    private double profit;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 开票时间
     */
    @Column(name = "INVOICE_TIME")
    private Date invoiceTime;

    /**
     * 发票号
     */
    @Column(name = "RECEIPT_NO")
    private String receiptNo;

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
     * 邮寄信息编号
     */
    @Column(name = "POST_ID")
    private String postId;
}