package com.gc.msagateway.msa.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrossDomainConfiguration {

    @Bean/*配置springmvc自带的过滤器解决跨域问题*/
    public CorsFilter corsFilter(){

        //Access-Control-Allow-Credentials

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);//是否允许携带COOKIE
        //设置允许的域名
        corsConfiguration.addAllowedOrigin("*");
        //corsConfiguration.addAllowedOrigin("http://manage.huangtiandi.top");
        //corsConfiguration.addAllowedOrigin("http://www.huangtiandi.top");



        UrlBasedCorsConfigurationSource uc = new UrlBasedCorsConfigurationSource();
        uc.registerCorsConfiguration("/**",corsConfiguration);


        return new CorsFilter(uc);
    }

}
