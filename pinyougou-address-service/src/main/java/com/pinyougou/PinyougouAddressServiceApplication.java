package com.pinyougou;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouAddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouAddressServiceApplication.class, args);
    }

}
