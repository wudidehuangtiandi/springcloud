package com.example.msauserinformationandauthority.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 电子口岸业务系统应用
个人中心应用
首页应用
 * @author GC
 * Create at 2020-04-23 14:59
 */
@Getter@Setter
public class AppManagerDto {

    /**
     * 编号
     */
    @Schema(title = "编号")
    public String id;

    /**
     * 应用名称
     */
    @Schema(title = "应用名称")
    public String appName;

    /**
     * 应用代码
     */
    @Schema(title = "应用代码")
    public String appCode;

    /**
     * 应用图标
     */
    @Schema(title = "应用图标")
    public String appPic;

    /**
     * 应用地址
     */
    @Schema(title = "应用地址")
    public String appAddress;

    /**
     * 应用介绍
     */
    @Schema(title = "应用介绍")
    public String appInfo;

    /**
     * 应用种类
     */
    @Schema(title = "应用种类")
    public String appType;

    /**
     * 是否需要配置菜单
     */
    @Schema(title = "是否需要配置菜单")
    public String needMucfg;

    /**
     * 状态
     */
    @Schema(title = "状态")
    public String appState;

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
     * 是否支持移动终端
     */
    @Schema(title = "是否支持移动终端")
    public String supportMobile;

    /**
     * 应用大图
     */
    @Schema(title = "应用大图")
    public String appBigPic;

    /**
     * APK类名
     */
    @Schema(title = "APK类名")
    public String apkClassName;

    /**
     * 产品推广地址
     */
    @Schema(title = "产品推广地址")
    public String appAdAddress;

    /**
     * 是否上线：0未上线；1已上线
     */
    @Schema(title = "是否上线：0未上线；1已上线")
    public String isOnLine;

    /**
     * 备注
     */
    @Schema(title = "备注")
    public String remark;

    /**
     * 排序号
     */
    @Schema(title = "排序号")
    public Integer orderNum;

    /**
     * 移动平台选择
     */
    @Schema(title = "移动平台选择")
    public String mobSelect;

    /**
     * 应用版本，1：旧 2：新
     */
    @Schema(title = "应用版本，1：旧 2：新")
    public String version;
}