package com.example.msauserinformationandauthority.api.controllers;

import com.example.msauserinformationandauthority.api.components.userbaseinfo.UserBaseinfoDataMapper;
import com.example.msauserinformationandauthority.api.components.userbaseinfo.UserBaseinfoEntityMapper;
import com.example.msauserinformationandauthority.api.config.JwtProperties;
import com.example.msauserinformationandauthority.api.models.userinfo.UserBaseinfoReturnDto;
import com.example.msauserinformationandauthority.api.utils.JwtUtils;
import com.example.msauserinformationandauthority.domain.models.*;
import com.example.msauserinformationandauthority.domain.repositories.UserBaseinfoRepository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@EnableConfigurationProperties(JwtProperties.class)
@Tag(name="用户详情")
@RequestMapping("/userinformation")
public class LoginController {

    private final EntityManager entityManager;

    private  JPAQueryFactory jpaQueryFactory;

    private final UserBaseinfoRepository userBaseinfoRepository;

    private final UserBaseinfoDataMapper userBaseinfoDataMapper;

    private final UserBaseinfoEntityMapper userBaseinfoEntityMapper;

    private  JwtProperties jwtProperties;

    public LoginController(EntityManager entityManager, UserBaseinfoRepository userBaseinfoRepository, UserBaseinfoDataMapper userBaseinfoDataMapper, UserBaseinfoEntityMapper userBaseinfoEntityMapper, JwtProperties jwtProperties) {
        this.entityManager = entityManager;
        this.userBaseinfoRepository = userBaseinfoRepository;
        this.userBaseinfoDataMapper = userBaseinfoDataMapper;
        this.userBaseinfoEntityMapper = userBaseinfoEntityMapper;
        this.jwtProperties = jwtProperties;
    }

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @GetMapping
    @Operation(summary = "用户信息获取")
    public UserBaseinfoReturnDto login(HttpServletRequest request /*@CookieValue("INVOICING_TOKEN")String token*/) throws Exception {
        String token1 = request.getHeader("Authorization");

        int i = token1.indexOf(" ");
        String token = token1.substring(i);

        UserBaseinfoReturnDto infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
        //获取角色
        QUserRole userRole = QUserRole.userRole;
        QUserBaseinfo userBaseinfo = QUserBaseinfo.userBaseinfo;
        QAppRole appRole = QAppRole.appRole;

        //只支持单个角色，为了避免报错故采用此写法，默认为查到的第一个角色
        List<UserRole> fetch = jpaQueryFactory.selectFrom(userRole).distinct().where(userRole.userId.eq(infoFromToken.id)).fetch();
        UserRole userRole1 = fetch.get(0);
        String roleId = userRole1.getRoleId();
        List<AppRole> fetch1 = jpaQueryFactory.selectFrom(appRole).distinct().where(appRole.id.eq(roleId)).fetch();
        AppRole appRole1 = fetch1.get(0);
        String roleCode = appRole1.getRoleCode();
        infoFromToken.setRoleCode(roleCode);

        return infoFromToken;
    }
}
