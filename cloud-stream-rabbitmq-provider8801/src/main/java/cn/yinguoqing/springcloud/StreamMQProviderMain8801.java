package cn.yinguoqing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMQProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderMain8801.class, args);
    }
}