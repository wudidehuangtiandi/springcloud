package com.example.msauserinformationandauthority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaUserinformationandauthorityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaUserinformationandauthorityApplication.class, args);
    }

}
