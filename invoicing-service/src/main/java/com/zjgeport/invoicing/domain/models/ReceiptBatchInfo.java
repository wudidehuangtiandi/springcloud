package com.zjgeport.invoicing.domain.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * 开票总信息
 * @author GC
 * Create at 2020-06-05 09:24
 */
@Entity
@Table(name = "RECEIPT_BATCH_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ReceiptBatchInfo {

    public ReceiptBatchInfo(String id) {
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
     * 发票张数
     */
    @Column(name = "TOTAL_RECEIPTS")
    private double totalReceipts;

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
     * 发票税率
     */
    @Column(name = "INVOICE_TAX_RATE")
    private double invoiceTaxRate;

    /**
     * 应缴平台税款
     */
    @Column(name = "PAY_TAX_FOR_PLATFORM")
    private double payTaxForPlatform;

    /**
     * 申请人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 申请人ID
     */
    @Column(name = "CREATE_USER_ID")
    private String createUserId;

    /**
     * 申请时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 申请机构
     */
    @Column(name = "CREATE_ORG")
    private String createOrg;

    /**
     * 申请机构ID
     */
    @Column(name = "CREATE_ORG_ID")
    private String createOrgId;

    /**
     * 状态
     */
    @Column(name = "APPLY_STATE")
    private String applyState;

    /**
     * 付款状态
     */
    @Column(name = "PAY_STATE")
    private String payState;

    /**
     * 收费方式
     */
    @Column(name = "CHARGE_METHOD")
    private String chargeMethod;

    /**
     * 银行流水号
     */
    @Column(name = "BANK_NUMBER")
    private String bankNumber;

    /**
     * 收费操作人员
     */
    @Column(name = "CONFIRM_USER")
    private String confirmUser;

    /**
     * 收费操作人员ID
     */
    @Column(name = "CONFIRM_USER_ID")
    private String confirmUserId;

    /**
     * 收费操作时间
     */
    @Column(name = "CONFIRM_DATE")
    private Date confirmDate;

    /**
     * 财务备注
     */
    @Column(name = "FINANCE_REMARK")
    private String financeRemark;

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
     * 对应付款给税务的编号
     */
    @Column(name = "PAY_TAX_ID")
    private String payTaxId;

    /**
     * 对应财政返款的编号
     */
    @Column(name = "FINANCE_RETURN_ID")
    private String financeReturnId;

    /**
     * 付款给税务的实际金额
     */
    @Column(name = "PAY_TAX_MONEY")
    private double payTaxMoney;

    /**
     * 付款给税务的时间
     */
    @Column(name = "PAY_TAX_TIME")
    private Date payTaxTime;

    /**
     * 财政反还的实际金额
     */
    @Column(name = "FINANCE_RETURN_MONEY")
    private double financeReturnMoney;

    /**
     * 财政反还的时间
     */
    @Column(name = "FINANCE_RETURN_TIME")
    private Date financeReturnTime;

    /**
     * 应缴税费j计算公式关联ID
     */
    @Column(name = "TAX_FORMULA_ID")
    private String taxFormulaId;

    /**
     * 应返税务公式关联ID
     */
    @Column(name = "RETURN_FORMULA_ID")
    private String returnFormulaId;
}