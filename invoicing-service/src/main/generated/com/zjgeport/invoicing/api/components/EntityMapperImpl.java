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
public class EntityMapperImpl implements EntityMapper {

    @Override
    public void assign(DriverInfo driverInfo, com.zjgeport.invoicing.api.models.DriverInfo info) {
        if ( info == null ) {
            return;
        }

        driverInfo.setId( info.id );
        driverInfo.setDriverName( info.driverName );
        driverInfo.setDriverSex( info.driverSex );
        driverInfo.setDriverPhone( info.driverPhone );
        driverInfo.setDriverIdNumber( info.driverIdNumber );
        driverInfo.setIdCardPeriondBegin( info.idCardPeriondBegin );
        driverInfo.setIdCardPeriondEnd( info.idCardPeriondEnd );
        driverInfo.setIdCardOppoImg( info.idCardOppoImg );
        driverInfo.setIdCardBgImg( info.idCardBgImg );
        driverInfo.setDriverLicensePeriodBegin( info.driverLicensePeriodBegin );
        driverInfo.setDriverLicensePeriodEnd( info.driverLicensePeriodEnd );
        driverInfo.setQualCertiNumber( info.qualCertiNumber );
        driverInfo.setQualCertiPeriodBegin( info.qualCertiPeriodBegin );
        driverInfo.setQualCertiPeriodEnd( info.qualCertiPeriodEnd );
        driverInfo.setCreateUser( info.createUser );
        driverInfo.setCreateUserId( info.createUserId );
        driverInfo.setCreateDate( info.createDate );
        driverInfo.setCreateOrg( info.createOrg );
        driverInfo.setCreateOrgId( info.createOrgId );
        driverInfo.setUpdateUser( info.updateUser );
        driverInfo.setUpdateUserId( info.updateUserId );
        driverInfo.setUpdateDate( info.updateDate );
        driverInfo.setUpdateOrg( info.updateOrg );
        driverInfo.setUpdateOrgId( info.updateOrgId );
        driverInfo.setCheckUser( info.checkUser );
        driverInfo.setCheckUserId( info.checkUserId );
        driverInfo.setCheckDate( info.checkDate );
        driverInfo.setState( info.state );
        driverInfo.setCheckAdvice( info.checkAdvice );
        driverInfo.setQualCertiImg( info.qualCertiImg );
        driverInfo.setDriverLicenseImg( info.driverLicenseImg );
    }

    @Override
    public void carassign(CarInfo carInfo, com.zjgeport.invoicing.api.models.CarInfo info) {
        if ( info == null ) {
            return;
        }

        carInfo.setId( info.getId() );
        carInfo.setCarNumber( info.getCarNumber() );
        carInfo.setCarBrand( info.getCarBrand() );
        carInfo.setCarNumberColor( info.getCarNumberColor() );
        carInfo.setCarWeight( info.getCarWeight() );
        carInfo.setLoadCapacity( info.getLoadCapacity() );
        carInfo.setAxleNumber( info.getAxleNumber() );
        carInfo.setCarLength( info.getCarLength() );
        carInfo.setCarWidth( info.getCarWidth() );
        carInfo.setCarHeight( info.getCarHeight() );
        carInfo.setRoadTransCertiNo( info.getRoadTransCertiNo() );
        carInfo.setRoadTransCertiBegin( info.getRoadTransCertiBegin() );
        carInfo.setRoadTransCertiEnd( info.getRoadTransCertiEnd() );
        carInfo.setDrivingLicenseNo( info.getDrivingLicenseNo() );
        carInfo.setDrivingLicenseBegin( info.getDrivingLicenseBegin() );
        carInfo.setDrivingLicenseEnd( info.getDrivingLicenseEnd() );
        carInfo.setDrivingLicenseDate( info.getDrivingLicenseDate() );
        carInfo.setDrivingLicenseOppoImg( info.getDrivingLicenseOppoImg() );
        carInfo.setDrivingLicenseBgImg( info.getDrivingLicenseBgImg() );
        carInfo.setRoadTransCertiImg( info.getRoadTransCertiImg() );
        carInfo.setCreateUser( info.getCreateUser() );
        carInfo.setCreateUserId( info.getCreateUserId() );
        carInfo.setCreateDate( info.getCreateDate() );
        carInfo.setCreateOrg( info.getCreateOrg() );
        carInfo.setCreateOrgId( info.getCreateOrgId() );
        carInfo.setUpdateUser( info.getUpdateUser() );
        carInfo.setUpdateUserId( info.getUpdateUserId() );
        carInfo.setUpdateDate( info.getUpdateDate() );
        carInfo.setUpdateOrg( info.getUpdateOrg() );
        carInfo.setUpdateOrgId( info.getUpdateOrgId() );
        carInfo.setCheckAdvice( info.getCheckAdvice() );
        carInfo.setState( info.getState() );
        carInfo.setCheckUser( info.getCheckUser() );
        carInfo.setCheckUserId( info.getCheckUserId() );
        carInfo.setCheckDate( info.getCheckDate() );
    }
}
