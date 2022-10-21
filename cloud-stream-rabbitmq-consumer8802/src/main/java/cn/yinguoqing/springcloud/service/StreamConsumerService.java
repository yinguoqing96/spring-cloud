package cn.yinguoqing.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author Yin Guoqing
 * @date 2022/10/21
 */
@Service
@Slf4j
public class StreamConsumerService {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 代码的方法名（即Consumer的bean实例名）需要是yml配置中的通道名，应用程序启动后会自动接收生产者发送的消息
     */
    @Bean
    public Consumer<String> myChannel() {
        return message -> log.info("端口号：{}, 消费消息：{}", serverPort, message);
    }
}