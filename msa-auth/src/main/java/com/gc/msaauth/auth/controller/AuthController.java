package com.gc.msaauth.auth.controller;


import com.gc.msaauth.auth.config.JwtProperties;
import com.gc.msaauth.auth.pojo.UserBaseinfoCheck;
import com.gc.msaauth.auth.pojo.UserInfo;
import com.gc.msaauth.auth.service.AuthService;
import com.gc.msaauth.auth.utils.CookieUtils;
import com.gc.msaauth.auth.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController("/api/auth")
@EnableConfigurationProperties(JwtProperties.class)
@Tag(name = "校验密码服务")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/accredit")
    @Operation(summary = "校验密码")
    public ResponseEntity<Void> accredit(@RequestBody UserBaseinfoCheck userBaseinfoCheck,
                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = authService.accredit(userBaseinfoCheck.getUsername(), userBaseinfoCheck.getPassword());
        if (StringUtils.isEmpty(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getExpire() * 60);
        response.setHeader("Authrization",token);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/verify")
    @Operation(summary = "刷新token")
    public ResponseEntity<UserInfo> verify(@CookieValue("INVOICING_TOKEN") String token, HttpServletRequest request, HttpServletResponse response){

        try {
            UserInfo infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            if (infoFromToken == null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            //用户在操作情况下刷新存活时间
            String s = JwtUtils.generateToken(infoFromToken, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), s, jwtProperties.getExpire() * 60);
            return ResponseEntity.ok(infoFromToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
