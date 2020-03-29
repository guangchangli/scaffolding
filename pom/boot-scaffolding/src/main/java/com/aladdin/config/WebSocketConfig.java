package com.aladdin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author lgc
 **/
@Configuration
public class WebSocketConfig {

    /**
     * 使用内置 tomcat 关闭 servlet 对  websocket 端点检查
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
