package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yin Guoqing
 * @date 2022/10/13
 */
@RestController
@RequestMapping("/order/consumer")
//@DefaultProperties(defaultFallback = "timeout_Global_fallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/success/{id}")
    public String success(@PathVariable("id") Integer id) {
        return paymentHystrixService.success(id);
    }

    @GetMapping("/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
//    @HystrixCommand
    public String timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.timeout(id);
    }

    public String timeout_handler(Integer id) {
        return "【order】: id: " + id + "  线程：" + Thread.currentThread().getName() + " timeout_handler....";
    }

    public String timeout_Global_fallback() {
        return "【order  timeout_Global_fallback】:  线程：" + Thread.currentThread().getName() + " timeout_handler....";
    }

}