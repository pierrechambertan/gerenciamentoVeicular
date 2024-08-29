package com.omnilink.veiculosclientesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VeiculosclientesapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeiculosclientesapiApplication.class, args);
    }

}
