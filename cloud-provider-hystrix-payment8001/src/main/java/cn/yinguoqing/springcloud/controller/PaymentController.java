package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
@RequestMapping("/payment/hystrix")
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @GetMapping("/success/{id}")
    public String success(@PathVariable("id") Integer id) {
        return paymentService.success(id);
    }

    @GetMapping("/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        return paymentService.timeout(id);
    }


}