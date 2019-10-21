package com.pinyougou;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouSellergoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouSellergoodsServiceApplication.class, args);
    }

      @Configuration
    public class MybatisConf {
        @Bean
        public PageHelper pageHelper() {
            System.out.println("MyBatisConfiguration.pageHelper()");
            PageHelper pageHelper = new PageHelper();
            Properties p = new Properties();
            p.setProperty("offsetAsPageNum", "true");
            p.setProperty("rowBoundsWithCount", "true");
            p.setProperty("reasonable", "true");
            pageHelper.setProperties(p);
            return pageHelper;
        }
    }

}
