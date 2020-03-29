package com.aladdin.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@EnableScheduling
public class TimeTask {
    //每分钟执行一次
    @Scheduled(cron = "0 */1 * * * ?")
    public void test() {
       log.info("*********   定时任务执行   **************");
        CopyOnWriteArraySet<MyWebSocket> webSocketSet =
                MyWebSocket.getWebSocketSet();
        webSocketSet.forEach(c -> {
            try {
                c.sendMessage("  定时发送  " + new Date().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        log.info(" 定时任务完成.......");
    }

}