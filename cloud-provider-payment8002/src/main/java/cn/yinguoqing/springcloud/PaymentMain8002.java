package cn.yinguoqing.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("cn.yinguoqing.springcloud.mapper")
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}