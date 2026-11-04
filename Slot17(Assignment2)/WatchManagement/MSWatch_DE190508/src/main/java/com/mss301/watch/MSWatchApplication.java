package com.mss301.watch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// [TODO-1.3, TODO-6.7: EnableFeignClients để gọi MSBrand]
@SpringBootApplication
@EnableFeignClients
public class MSWatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MSWatchApplication.class, args);
    }
}
