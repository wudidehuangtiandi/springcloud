package com.gc.msalogin.api.components.userbaseinfo;


import com.gc.msalogin.api.models.userinfo.UserBaseinfoCheck;
import com.gc.msalogin.api.models.userinfo.UserBaseinfoReturn;
import com.gc.msalogin.domain.models.UserBaseinfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserBaseinfoEntityMapper {

    UserBaseinfo toEntity(UserBaseinfoCheck dto);

    void assign(@MappingTarget UserBaseinfoReturn entity, UserBaseinfo dto);

    default UserBaseinfoReturn newEntity() {

        return new UserBaseinfoReturn();
    }

}
