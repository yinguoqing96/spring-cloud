package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.common.Result;
import cn.yinguoqing.springcloud.entity.Payment;
import cn.yinguoqing.springcloud.service.PaymentApiService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yinguoqing
 * @date 2022/9/15
 */

@RequestMapping("/feign")
@RestController
public class OrderController {

    @Resource
    private PaymentApiService paymentApiService;

    @PostMapping("/consumer/payment/create")
    public Result create(@RequestBody Payment payment) {
        return paymentApiService.create(payment);
    }

    @GetMapping("/consumer/payment/getId/{id}")
    public Result getId(@PathVariable("id") Long id) {
        return paymentApiService.getId(id);
    }

    @GetMapping("/consumer/payment/query")
    public Result query() {
        return paymentApiService.query();
    }
}