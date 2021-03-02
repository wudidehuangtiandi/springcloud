package com.zjgeport.invoicing.api.components;

import com.zjgeport.invoicing.domain.primary.models.CarInfo;
import com.zjgeport.invoicing.domain.primary.models.DriverInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-03T09:51:45+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class DataMapperImpl implements DataMapper {

    @Override
    public com.zjgeport.invoicing.api.models.DriverInfo map(DriverInfo driverInfo) {
        if ( driverInfo == null ) {
            return null;
        }

        com.zjgeport.invoicing.api.models.DriverInfo driverInfo1 = new com.zjgeport.invoicing.api.models.DriverInfo();

        driverInfo1.id = driverInfo.getId();
        driverInfo1.driverName = driverInfo.getDriverName();
        driverInfo1.driverSex = driverInfo.getDriverSex();
        driverInfo1.driverPhone = driverInfo.getDriverPhone();
        driverInfo1.driverIdNumber = driverInfo.getDriverIdNumber();
        driverInfo1.idCardPeriondBegin = driverInfo.getIdCardPeriondBegin();
        driverInfo1.idCardPeriondEnd = driverInfo.getIdCardPeriondEnd();
        driverInfo1.idCardOppoImg = driverInfo.getIdCardOppoImg();
        driverInfo1.idCardBgImg = driverInfo.getIdCardBgImg();
        driverInfo1.driverLicensePeriodBegin = driverInfo.getDriverLicensePeriodBegin();
        driverInfo1.driverLicensePeriodEnd = driverInfo.getDriverLicensePeriodEnd();
        driverInfo1.qualCertiNumber = driverInfo.getQualCertiNumber();
        driverInfo1.qualCertiPeriodBegin = driverInfo.getQualCertiPeriodBegin();
        driverInfo1.qualCertiPeriodEnd = driverInfo.getQualCertiPeriodEnd();
        driverInfo1.createUser = driverInfo.getCreateUser();
        driverInfo1.createUserId = driverInfo.getCreateUserId();
        driverInfo1.createDate = driverInfo.getCreateDate();
        driverInfo1.createOrg = driverInfo.getCreateOrg();
        driverInfo1.createOrgId = driverInfo.getCreateOrgId();
        driverInfo1.updateUser = driverInfo.getUpdateUser();
        driverInfo1.updateUserId = driverInfo.getUpdateUserId();
        driverInfo1.updateDate = driverInfo.getUpdateDate();
        driverInfo1.updateOrg = driverInfo.getUpdateOrg();
        driverInfo1.updateOrgId = driverInfo.getUpdateOrgId();
        driverInfo1.checkUser = driverInfo.getCheckUser();
        driverInfo1.checkUserId = driverInfo.getCheckUserId();
        driverInfo1.checkDate = driverInfo.getCheckDate();
        driverInfo1.state = driverInfo.getState();
        driverInfo1.checkAdvice = driverInfo.getCheckAdvice();
        driverInfo1.qualCertiImg = driverInfo.getQualCertiImg();
        driverInfo1.driverLicenseImg = driverInfo.getDriverLicenseImg();

        return driverInfo1;
    }

    @Override
    public com.zjgeport.invoicing.api.models.CarInfo map(CarInfo carInfo) {
        if ( carInfo == null ) {
            return null;
        }

        com.zjgeport.invoicing.api.models.CarInfo carInfo1 = new com.zjgeport.invoicing.api.models.CarInfo();

        carInfo1.setId( carInfo.getId() );
        carInfo1.setCarNumber( carInfo.getCarNumber() );
        carInfo1.setCarBrand( carInfo.getCarBrand() );
        carInfo1.setCarNumberColor( carInfo.getCarNumberColor() );
        carInfo1.setCarWeight( carInfo.getCarWeight() );
        carInfo1.setLoadCapacity( carInfo.getLoadCapacity() );
        carInfo1.setAxleNumber( carInfo.getAxleNumber() );
        carInfo1.setCarLength( carInfo.getCarLength() );
        carInfo1.setCarWidth( carInfo.getCarWidth() );
        carInfo1.setCarHeight( carInfo.getCarHeight() );
        carInfo1.setRoadTransCertiNo( carInfo.getRoadTransCertiNo() );
        carInfo1.setRoadTransCertiBegin( carInfo.getRoadTransCertiBegin() );
        carInfo1.setRoadTransCertiEnd( carInfo.getRoadTransCertiEnd() );
        carInfo1.setDrivingLicenseNo( carInfo.getDrivingLicenseNo() );
        carInfo1.setDrivingLicenseBegin( carInfo.getDrivingLicenseBegin() );
        carInfo1.setDrivingLicenseEnd( carInfo.getDrivingLicenseEnd() );
        carInfo1.setDrivingLicenseDate( carInfo.getDrivingLicenseDate() );
        carInfo1.setDrivingLicenseOppoImg( carInfo.getDrivingLicenseOppoImg() );
        carInfo1.setDrivingLicenseBgImg( carInfo.getDrivingLicenseBgImg() );
        carInfo1.setRoadTransCertiImg( carInfo.getRoadTransCertiImg() );
        carInfo1.setCreateUser( carInfo.getCreateUser() );
        carInfo1.setCreateUserId( carInfo.getCreateUserId() );
        carInfo1.setCreateDate( carInfo.getCreateDate() );
        carInfo1.setCreateOrg( carInfo.getCreateOrg() );
        carInfo1.setCreateOrgId( carInfo.getCreateOrgId() );
        carInfo1.setUpdateUser( carInfo.getUpdateUser() );
        carInfo1.setUpdateUserId( carInfo.getUpdateUserId() );
        carInfo1.setUpdateDate( carInfo.getUpdateDate() );
        carInfo1.setUpdateOrg( carInfo.getUpdateOrg() );
        carInfo1.setUpdateOrgId( carInfo.getUpdateOrgId() );
        carInfo1.setCheckAdvice( carInfo.getCheckAdvice() );
        carInfo1.setState( carInfo.getState() );
        carInfo1.setCheckUser( carInfo.getCheckUser() );
        carInfo1.setCheckUserId( carInfo.getCheckUserId() );
        carInfo1.setCheckDate( carInfo.getCheckDate() );

        return carInfo1;
    }
}
