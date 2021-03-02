package com.gc.msalogin.api.controllers;

import com.gc.msalogin.api.components.userbaseinfo.UserBaseinfoDataMapper;
import com.gc.msalogin.api.components.userbaseinfo.UserBaseinfoEntityMapper;
import com.gc.msalogin.api.models.userinfo.UserBaseinfoCheck;
import com.gc.msalogin.api.models.userinfo.UserBaseinfoReturn;
import com.gc.msalogin.api.utils.MD5Utils;
import com.gc.msalogin.domain.models.QUserBaseinfo;
import com.gc.msalogin.domain.models.UserBaseinfo;
import com.gc.msalogin.domain.models.models.AppRole;
import com.gc.msalogin.domain.models.models.QAppRole;
import com.gc.msalogin.domain.models.models.QUserRole;
import com.gc.msalogin.domain.models.models.UserRole;
import com.gc.msalogin.domain.repositories.UserBaseinfoRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;


@RestController
@RequestMapping("/login")
@Tag(name="用户登录")
public class LoginController {

    private final EntityManager entityManager;

    private JPAQueryFactory jpaQueryFactory;

    private final UserBaseinfoRepository userBaseinfoRepository;

    private final UserBaseinfoDataMapper userBaseinfoDataMapper;

    private final UserBaseinfoEntityMapper userBaseinfoEntityMapper;

    public LoginController(EntityManager  entityManager, UserBaseinfoRepository userBaseinfoRepository, UserBaseinfoDataMapper userBaseinfoDataMapper, UserBaseinfoEntityMapper userBaseinfoEntityMapper) {
        this.entityManager = entityManager;
        this.userBaseinfoRepository = userBaseinfoRepository;
        this.userBaseinfoDataMapper = userBaseinfoDataMapper;
        this.userBaseinfoEntityMapper = userBaseinfoEntityMapper;
    }

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @PostMapping
    @Operation(summary = "用户登录")
    public UserBaseinfoReturn login(@RequestBody UserBaseinfoCheck userBaseinfoCheck){

        UserBaseinfo userBaseinfo = userBaseinfoEntityMapper.toEntity(userBaseinfoCheck);

        QUserBaseinfo userBaseinfo1 = QUserBaseinfo.userBaseinfo;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(userBaseinfo1.username.eq(userBaseinfo.getUsername()));
        booleanBuilder.and(userBaseinfo1.state.eq("2"));

        JPAQuery<UserBaseinfo> where = jpaQueryFactory.selectFrom(userBaseinfo1).where(booleanBuilder);
        QueryResults<UserBaseinfo> userBaseinfoQueryResults = where.fetchResults();
        List<UserBaseinfo> results = userBaseinfoQueryResults.getResults();
        assert results.size()==1;

        UserBaseinfo userBaseinfo2 = results.get(0);
        String password = userBaseinfo.getPassword();

        UserBaseinfoReturn userBaseinfoReturn = userBaseinfoEntityMapper.newEntity();
        userBaseinfoEntityMapper.assign(userBaseinfoReturn,userBaseinfo2);

        //获取角色
        QUserRole userRole = QUserRole.userRole;
        QAppRole appRole = QAppRole.appRole;

        //只支持单个角色，为了避免报错故采用此写法，默认为查到的第一个角色
        List<UserRole> fetch = jpaQueryFactory.selectFrom(userRole).distinct().where(userRole.userId.eq(userBaseinfoReturn.getId())).fetch();
        UserRole userRole1 = fetch.get(0);
        String roleId = userRole1.getRoleId();
        List<AppRole> fetch1 = jpaQueryFactory.selectFrom(appRole).distinct().where(appRole.id.eq(roleId)).fetch();
        AppRole appRole1 = fetch1.get(0);
        String roleCode = appRole1.getRoleCode();
        userBaseinfoReturn.setRoleCode(roleCode);

        if(userBaseinfo2.getPassword().equals(MD5Utils.toMD5(password))){
            return userBaseinfoReturn;
        }else {
            return null;
        }
    }
 }
