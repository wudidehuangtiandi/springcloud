package com.example.msauserinformationandauthority.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 信息分开

确认字段

单位人员维护

挂靠权限控制

机构类型以ID:ID的形式保存
 * @author GC
 * Create at 2020-04-23 15:00
 */
@Getter@Setter
public class OrgBaseinfoDto {

    /**
     * 编号
     */
    @Schema(title = "编号")
    public String id;

    /**
     * 中文名称
     */
    @Schema(title = "中文名称")
    public String orgNameCn;

    /**
     * 中文简称
     */
    @Schema(title = "中文简称")
    public String orgNameScn;

    /**
     * 组织机构代码
     */
    @Schema(title = "组织机构代码")
    public String orgCode;

    /**
     * 营业执照号
     */
    @Schema(title = "营业执照号")
    public String busLicCode;

    /**
     * 税务登记号
     */
    @Schema(title = "税务登记号")
    public String taxCode;

    /**
     * 中文地址
     */
    @Schema(title = "中文地址")
    public String addressCn;

    /**
     * 机构性质
     */
    @Schema(title = "机构性质")
    public String orgProperty;

    /**
     * 机构类型
     */
    @Schema(title = "机构类型")
    public String orgType;

    /**
     * 法人姓名
     */
    @Schema(title = "法人姓名")
    public String legalName;

    /**
     * 法人电话
     */
    @Schema(title = "法人电话")
    public String legalPhone;

    /**
     * 证件类型
     */
    @Schema(title = "证件类型")
    public String certType;

    /**
     * 证件号
     */
    @Schema(title = "证件号")
    public String certNo;

    /**
     * 所在省
     */
    @Schema(title = "所在省")
    public String sheng;

    /**
     * 所在市
     */
    @Schema(title = "所在市")
    public String shi;

    /**
     * 所在区县
     */
    @Schema(title = "所在区县")
    public String quxian;

    /**
     * 行政区域代码
     */
    @Schema(title = "行政区域代码")
    public String areaCode;

    /**
     * 企业LOGO
     */
    @Schema(title = "企业LOGO")
    public String logo;

    /**
     * 排序号
     */
    @Schema(title = "排序号")
    public Integer orderNum;

    /**
     * 注册方式
     */
    @Schema(title = "注册方式")
    public String regType;

    /**
     * 审核状态
     */
    @Schema(title = "审核状态")
    public String checkState;

    /**
     * 审核意见
     */
    @Schema(title = "审核意见")
    public String checkAdv;

    /**
     * 审核时间
     */
    @Schema(title = "审核时间")
    public OffsetDateTime checkSuccTime;

    /**
     * 备注
     */
    @Schema(title = "备注")
    public String remark;

    /**
     * 创建人
     */
    @Schema(title = "创建人")
    public String createUser;

    /**
     * 创建人ID
     */
    @Schema(title = "创建人ID")
    public String createUserId;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    public OffsetDateTime createDate;

    /**
     * 修改人
     */
    @Schema(title = "修改人")
    public String updateUser;

    /**
     * 修改人ID
     */
    @Schema(title = "修改人ID")
    public String updateUserId;

    /**
     * 修改时间
     */
    @Schema(title = "修改时间")
    public OffsetDateTime updateDate;

    /**
     * 区域名称
     */
    @Schema(title = "区域名称")
    public String areaName;

    /**
     * 账户状态
     */
    @Schema(title = "账户状态")
    public String state;

    /**
     * 企业简称编码
     */
    @Schema(title = "企业简称编码")
    public String orgSnameCode;

    /**
     * 电子口岸企业编码
     */
    @Schema(title = "电子口岸企业编码")
    public String corpCode;
}