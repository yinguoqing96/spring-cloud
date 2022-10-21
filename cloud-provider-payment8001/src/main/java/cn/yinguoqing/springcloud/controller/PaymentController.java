package cn.yinguoqing.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import cn.yinguoqing.springcloud.common.Result;
import cn.yinguoqing.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
@RequestMapping("/payment")
@RestController
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        return new Result<>(500, "插入成功,端口：" + serverPort, payment);
    }

    @GetMapping("/getId/{id}")
    public Result getId(@PathVariable("id") Long id) {
        Payment payment = new Payment();
        payment.setId(id);
        payment.setSerial(IdUtil.simpleUUID());
        return new Result<>(200, "查询成功,端口：" + serverPort, payment);
    }

    @GetMapping("/lb")
    public Result lb() {
        return new Result<>(200, "查询成功,端口：" + serverPort);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost());
                System.out.println(instance.getPort());
                System.out.println(instance.getUri());
            }
        }
        return null;
    }


    @GetMapping("/query")
    public Result query() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSerial(IdUtil.simpleUUID());
        List<Payment> result = new ArrayList<>();
        result.add(payment);
        return new Result<>(200, "查询成功,端口：" + serverPort, result);
    }
}