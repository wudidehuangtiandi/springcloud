package com.zjgeport.invoicing.domain.primary.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDriverInfo is a Querydsl query type for DriverInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDriverInfo extends EntityPathBase<DriverInfo> {

    private static final long serialVersionUID = 1345800454L;

    public static final QDriverInfo driverInfo = new QDriverInfo("driverInfo");

    public final StringPath checkAdvice = createString("checkAdvice");

    public final DateTimePath<java.time.Date> checkDate = createDateTime("checkDate", java.time.Date.class);

    public final StringPath checkUser = createString("checkUser");

    public final StringPath checkUserId = createString("checkUserId");

    public final DateTimePath<java.time.Date> createDate = createDateTime("createDate", java.time.Date.class);

    public final StringPath createOrg = createString("createOrg");

    public final StringPath createOrgId = createString("createOrgId");

    public final StringPath createUser = createString("createUser");

    public final StringPath createUserId = createString("createUserId");

    public final StringPath driverIdNumber = createString("driverIdNumber");

    public final StringPath driverLicenseImg = createString("driverLicenseImg");

    public final DateTimePath<java.time.Date> driverLicensePeriodBegin = createDateTime("driverLicensePeriodBegin", java.time.Date.class);

    public final DateTimePath<java.time.Date> driverLicensePeriodEnd = createDateTime("driverLicensePeriodEnd", java.time.Date.class);

    public final StringPath driverName = createString("driverName");

    public final StringPath driverPhone = createString("driverPhone");

    public final StringPath driverSex = createString("driverSex");

    public final StringPath id = createString("id");

    public final StringPath idCardBgImg = createString("idCardBgImg");

    public final StringPath idCardOppoImg = createString("idCardOppoImg");

    public final DateTimePath<java.time.Date> idCardPeriondBegin = createDateTime("idCardPeriondBegin", java.time.Date.class);

    public final DateTimePath<java.time.Date> idCardPeriondEnd = createDateTime("idCardPeriondEnd", java.time.Date.class);

    public final StringPath qualCertiImg = createString("qualCertiImg");

    public final StringPath qualCertiNumber = createString("qualCertiNumber");

    public final DateTimePath<java.time.Date> qualCertiPeriodBegin = createDateTime("qualCertiPeriodBegin", java.time.Date.class);

    public final DateTimePath<java.time.Date> qualCertiPeriodEnd = createDateTime("qualCertiPeriodEnd", java.time.Date.class);

    public final StringPath state = createString("state");

    public final DateTimePath<java.time.Date> updateDate = createDateTime("updateDate", java.time.Date.class);

    public final StringPath updateOrg = createString("updateOrg");

    public final StringPath updateOrgId = createString("updateOrgId");

    public final StringPath updateUser = createString("updateUser");

    public final StringPath updateUserId = createString("updateUserId");

    public QDriverInfo(String variable) {
        super(DriverInfo.class, forVariable(variable));
    }

    public QDriverInfo(Path<? extends DriverInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDriverInfo(PathMetadata metadata) {
        super(DriverInfo.class, metadata);
    }

}

