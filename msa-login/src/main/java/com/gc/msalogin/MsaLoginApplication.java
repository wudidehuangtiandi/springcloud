package com.gc.msalogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaLoginApplication.class, args);
    }

}
