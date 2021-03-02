package com.zjgeport.invoicing.domain.primary.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarInfo is a Querydsl query type for CarInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarInfo extends EntityPathBase<CarInfo> {

    private static final long serialVersionUID = -693756782L;

    public static final QCarInfo carInfo = new QCarInfo("carInfo");

    public final NumberPath<Long> axleNumber = createNumber("axleNumber", Long.class);

    public final StringPath carBrand = createString("carBrand");

    public final NumberPath<Long> carHeight = createNumber("carHeight", Long.class);

    public final NumberPath<Long> carLength = createNumber("carLength", Long.class);

    public final StringPath carNumber = createString("carNumber");

    public final StringPath carNumberColor = createString("carNumberColor");

    public final NumberPath<Long> carWeight = createNumber("carWeight", Long.class);

    public final NumberPath<Long> carWidth = createNumber("carWidth", Long.class);

    public final StringPath checkAdvice = createString("checkAdvice");

    public final DateTimePath<java.time.Date> checkDate = createDateTime("checkDate", java.time.Date.class);

    public final StringPath checkUser = createString("checkUser");

    public final StringPath checkUserId = createString("checkUserId");

    public final DateTimePath<java.time.Date> createDate = createDateTime("createDate", java.time.Date.class);

    public final StringPath createOrg = createString("createOrg");

    public final StringPath createOrgId = createString("createOrgId");

    public final StringPath createUser = createString("createUser");

    public final StringPath createUserId = createString("createUserId");

    public final DateTimePath<java.time.Date> drivingLicenseBegin = createDateTime("drivingLicenseBegin", java.time.Date.class);

    public final StringPath drivingLicenseBgImg = createString("drivingLicenseBgImg");

    public final DateTimePath<java.time.Date> drivingLicenseDate = createDateTime("drivingLicenseDate", java.time.Date.class);

    public final DateTimePath<java.time.Date> drivingLicenseEnd = createDateTime("drivingLicenseEnd", java.time.Date.class);

    public final StringPath drivingLicenseNo = createString("drivingLicenseNo");

    public final StringPath drivingLicenseOppoImg = createString("drivingLicenseOppoImg");

    public final StringPath id = createString("id");

    public final NumberPath<Long> loadCapacity = createNumber("loadCapacity", Long.class);

    public final DateTimePath<java.time.Date> roadTransCertiBegin = createDateTime("roadTransCertiBegin", java.time.Date.class);

    public final DateTimePath<java.time.Date> roadTransCertiEnd = createDateTime("roadTransCertiEnd", java.time.Date.class);

    public final StringPath roadTransCertiImg = createString("roadTransCertiImg");

    public final StringPath roadTransCertiNo = createString("roadTransCertiNo");

    public final StringPath state = createString("state");

    public final DateTimePath<java.time.Date> updateDate = createDateTime("updateDate", java.time.Date.class);

    public final StringPath updateOrg = createString("updateOrg");

    public final StringPath updateOrgId = createString("updateOrgId");

    public final StringPath updateUser = createString("updateUser");

    public final StringPath updateUserId = createString("updateUserId");

    public QCarInfo(String variable) {
        super(CarInfo.class, forVariable(variable));
    }

    public QCarInfo(Path<? extends CarInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarInfo(PathMetadata metadata) {
        super(CarInfo.class, metadata);
    }

}

