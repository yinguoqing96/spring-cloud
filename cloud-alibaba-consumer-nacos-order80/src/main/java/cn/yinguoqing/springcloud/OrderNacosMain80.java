package cn.yinguoqing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yin Guoqing
 * @date 2022/9/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain80.class, args);
    }
}