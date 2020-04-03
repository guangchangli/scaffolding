package com.aladdin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootScaffoldingApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
