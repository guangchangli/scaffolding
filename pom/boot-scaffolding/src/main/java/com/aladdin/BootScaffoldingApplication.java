package com.aladdin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.aladdin.dao"})
public class BootScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootScaffoldingApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
