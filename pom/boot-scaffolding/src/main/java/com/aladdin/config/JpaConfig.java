package com.aladdin.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 **/
@Configuration
public class JpaConfig extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8_general_ci";
    }
}
