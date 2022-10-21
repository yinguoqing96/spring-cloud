package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.common.Result;
import cn.yinguoqing.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Yin Guoqing
 * @date 2022/9/15
 */

@RequestMapping("order")
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public Result create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, Result.class);
    }

    @GetMapping("/consumer/payment/getId/{id}")
    public Result create(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getId/" + id, Result.class);
    }

    @GetMapping("/consumer/payment/query")
    public Result query() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/query", Result.class);
    }
}