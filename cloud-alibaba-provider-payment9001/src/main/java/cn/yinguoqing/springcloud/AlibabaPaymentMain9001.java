package cn.yinguoqing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9001.class, args);
    }
}