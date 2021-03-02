package com.gc.msaauth.auth.client;

import com.gc.msaauth.auth.pojo.UserBaseinfoCheck;
import com.gc.msaauth.auth.pojo.UserBaseinfoReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "invoicing-service-login")
public interface LoginClient  {

    @PostMapping("/login")
    public UserBaseinfoReturn login(@RequestBody UserBaseinfoCheck userBaseinfoCheck);

}
