package com.gc.msaauth;

import com.gc.msaauth.auth.pojo.UserInfo;
import com.gc.msaauth.auth.utils.JwtUtils;
import com.gc.msaauth.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;


import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "d:\\miyao\\rsa.pub";

    private static final String priKeyPath = "d:\\miyao\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

   /* @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }*/

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "q1w2?!~aaa");
    }



    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
       // String token = JwtUtils.generateToken(new UserInfo("a","a","a","a","a"), privateKey, 5);
       // System.out.println("token = " + token);
    }

    @Test
    public void testParseToken()  {
    /*    String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2NTgzMzYyOX0.RA86gA1-XL75IZHik_Kz92_3auS_xJCfznLE2pmda4ssw_7P65YAJhKt2x5iXT3MmDCT96uMj0qkQT8e_1wzVywa04ScRjJV2YGIBujWbtIAzm3hD3lRonCuhBh5sHCCA_7RlHxiN67pcj0rsmsfOtyoQK6wXGSIcG_ob5Y4J2g";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }*/
}}