package com.gc.msaauth.auth.service;


import com.gc.msaauth.auth.client.LoginClient;
import com.gc.msaauth.auth.config.JwtProperties;
import com.gc.msaauth.auth.pojo.UserBaseinfoCheck;
import com.gc.msaauth.auth.pojo.UserBaseinfoReturn;
import com.gc.msaauth.auth.pojo.UserInfo;
import com.gc.msaauth.auth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {
    @Autowired
    private LoginClient loginClient;
    @Autowired
    private JwtProperties jwtProperties;

    public String accredit(String username, String password) throws Exception {
        UserBaseinfoCheck userBaseinfoCheck = new UserBaseinfoCheck();
        userBaseinfoCheck.setUsername(username);
        userBaseinfoCheck.setPassword(password);
        UserBaseinfoReturn user = loginClient.login(userBaseinfoCheck);
        //UserBaseinfoReturnDto login = getRolesClient.login();
        if (user == null){
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setIsAdmin(user.getIsAdmin());
        userInfo.setNickname(user.getNickname());
        userInfo.setOrgId(user.getOrgId());
        userInfo.setUsername(user.getUsername());
        userInfo.setRoleCode(user.getRoleCode());


        //生成token
        String s =null;
        try {
            s = JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());//获取密钥工作由JwtProperties来完成这边只要注入
        } catch (Exception e) {

            return null;
        }
        return s;
    }





}
