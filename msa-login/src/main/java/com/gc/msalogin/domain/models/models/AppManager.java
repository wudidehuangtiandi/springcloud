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
 * 电子口岸业务系统应用
个人中心应用
首页应用
 * @author GC
 * Create at 2020-04-23 14:59
 */
@Entity
@Table(name = "APP_MANAGER")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class AppManager {

    public AppManager(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 应用名称
     */
    @Column(name = "APP_NAME")
    private String appName;

    /**
     * 应用代码
     */
    @Column(name = "APP_CODE")
    private String appCode;

    /**
     * 应用图标
     */
    @Column(name = "APP_PIC")
    private String appPic;

    /**
     * 应用地址
     */
    @Column(name = "APP_ADDRESS")
    private String appAddress;

    /**
     * 应用介绍
     */
    @Column(name = "APP_INFO")
    private String appInfo;

    /**
     * 应用种类
     */
    @Column(name = "APP_TYPE")
    private String appType;

    /**
     * 是否需要配置菜单
     */
    @Column(name = "NEED_MUCFG")
    private String needMucfg;

    /**
     * 状态
     */
    @Column(name = "APP_STATE")
    private String appState;

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
     * 是否支持移动终端
     */
    @Column(name = "SUPPORT_MOBILE")
    private String supportMobile;

    /**
     * 应用大图
     */
    @Column(name = "APP_BIG_PIC")
    private String appBigPic;

    /**
     * APK类名
     */
    @Column(name = "APK_CLASS_NAME")
    private String apkClassName;

    /**
     * 产品推广地址
     */
    @Column(name = "APP_AD_ADDRESS")
    private String appAdAddress;

    /**
     * 是否上线：0未上线；1已上线
     */
    @Column(name = "IS_ON_LINE")
    private String isOnLine;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 排序号
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * 移动平台选择
     */
    @Column(name = "MOB_SELECT")
    private String mobSelect;

    /**
     * 应用版本，1：旧 2：新
     */
    @Column(name = "VERSION")
    private String version;
}