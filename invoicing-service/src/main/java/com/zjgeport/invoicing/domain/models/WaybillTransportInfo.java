package com.zjgeport.invoicing.domain.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import javax.persistence.*;

import java.util.Date;

/**
 * 运输信息
 * @author GC
 * Create at 2020-06-04 15:18
 */
@Entity
@Table(name = "WAYBILL_TRANSPORT_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class WaybillTransportInfo {

    public WaybillTransportInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 所属运单合同编号
     */
    @Column(name = "WAYBILL_CONTRACT_ID")
    private String waybillContractId;

    /**
     * 运单号
     */
    @Column(name = "WAYBILL_NO")
    private String waybillNo;

    /**
     * 司机编号
     */
    @Column(name = "DRIVER_ID")
    private String driverId;

    /**
     * 车辆编号
     */
    @Column(name = "CAR_ID")
    private String carId;

    /**
     * 司机名称
     */
    @Column(name = "DRIVER_NAME")
    private String driverName;

    /**
     * 车牌号
     */
    @Column(name = "CAR_NUMBER")
    private String carNumber;

    /**
     * 回单照片
     */
    @Column(name = "RECEIPT_PHOTO_IMG")
    private String receiptPhotoImg;

    /**
     * 发货时间
     */
    @Column(name = "SEND_DATE")
    private Date sendDate;

    /**
     * 收货时间
     */
    @Column(name = "RECEIVE_DATE")
    private Date receiveDate;
}