package cn.yinguoqing.springcloud.service;

import cn.yinguoqing.springcloud.common.Result;
import cn.yinguoqing.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Yin Guoqing
 * @date 2022/9/18
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentApiService {

    @PostMapping("/payment/create")
    Result create(Payment payment);
    @GetMapping("/payment/getId/{id}")
    Result getId(@PathVariable("id") Long id);
    @GetMapping("/payment/query")
    Result query();


}