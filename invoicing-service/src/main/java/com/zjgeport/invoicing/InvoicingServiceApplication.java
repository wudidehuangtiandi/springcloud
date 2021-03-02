package com.zjgeport.invoicing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.zjgeport.framework.spring.webmvc.support.DefaultConfig;
import org.zjgeport.framework.springdoc.openapi.PagingDocSupport;

@SpringBootApplication
@Import({DefaultConfig.class, PagingDocSupport.class})
@EnableDiscoveryClient
public class InvoicingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoicingServiceApplication.class, args);
    }

}
