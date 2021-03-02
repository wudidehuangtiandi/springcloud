package com.zjgeport.invoicing.domain.models;


import lombok.*;
import javax.persistence.*;


/**
 * 运单货物信息
 * @author GC
 * Create at 2020-06-04 15:18
 */
@Entity
@Table(name = "WAYBILL_CARGO_INFO")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class WaybillCargoInfo {

    public WaybillCargoInfo(String id) {
        this.id = id;
    }

    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 对应运单编号
     */
    @Column(name = "WAYBILL_ID")
    private String waybillId;

    /**
     * 货物名称
     */
    @Column(name = "CARGO_NAME")
    private String cargoName;

    /**
     * 货物类型
     */
    @Column(name = "CARGO_TYPE")
    private String cargoType;

    /**
     * 货物重量
     */
    @Column(name = "CARGO_WEIGHT")
    private double cargoWeight;

    /**
     * 货物数量
     */
    @Column(name = "CARGO_AMOUNT")
    private double cargoAmount;

    /**
     * 货物计量单位
     */
    @Column(name = "CARGO_UNIT")
    private String cargoUnit;


    @Transient //用来查询所用
    private String waybillNo;
}