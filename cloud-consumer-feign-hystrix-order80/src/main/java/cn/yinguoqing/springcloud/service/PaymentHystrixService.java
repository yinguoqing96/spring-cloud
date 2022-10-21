package cn.yinguoqing.springcloud.service;

import cn.yinguoqing.springcloud.fallback.PaymentHystrixGlobalFallback;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yin Guoqing
 * @date 2022/10/13
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixGlobalFallback.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/success/{id}")
    String success(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String timeout(@PathVariable("id") Integer id);

}