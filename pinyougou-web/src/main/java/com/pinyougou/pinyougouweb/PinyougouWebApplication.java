package com.pinyougou.pinyougouweb;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouWebApplication.class, args);
    }

}
