package cn.yinguoqing.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
@SpringBootApplication
@MapperScan("cn.yinguoqing.springcloud.mapper")
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}