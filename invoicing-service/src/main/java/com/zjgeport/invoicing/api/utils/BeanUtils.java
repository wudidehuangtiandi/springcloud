package com.zjgeport.invoicing.api.utils;

import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.BooleanBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class BeanUtils {

    @Bean
    @Scope("prototype")
    public BooleanBuilder newBooleanBuilder(){
        return new BooleanBuilder();
    }

    @Bean
    @Scope("prototype")
    public JSONObject newJsonObject(){
        return new JSONObject();
    }


}
