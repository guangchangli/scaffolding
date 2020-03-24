package com.aladdin.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 **/
@Configuration
public class DozenBeanMapperConfig {
    @Bean
    public DozerBeanMapper mapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        return dozerBeanMapper;
    }
}
