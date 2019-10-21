package com.pinyigou.pinyougoucartservice;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouCartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouCartServiceApplication.class, args);
    }

}
