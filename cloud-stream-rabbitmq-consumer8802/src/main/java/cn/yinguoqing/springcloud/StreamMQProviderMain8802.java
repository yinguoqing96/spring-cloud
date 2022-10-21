package cn.yinguoqing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMQProviderMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderMain8802.class, args);
    }
}