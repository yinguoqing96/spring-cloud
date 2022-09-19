package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.common.Result;
import cn.yinguoqing.springcloud.entity.Payment;
import cn.yinguoqing.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
@RequestMapping("/payment")
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new Result<>(200, "插入成功,端口：" + serverPort, result);
        }
        return new Result<>(500, "插入成功,端口：" + serverPort);
    }

    @GetMapping("/getId/{id}")
    public Result getId(@PathVariable("id") Long id) {
        Payment payment = paymentService.getId(id);
        if (Optional.ofNullable(payment).isPresent()) {
            return new Result<>(200, "查询成功,端口：" + serverPort, payment);
        }
        return new Result<>(500, "查询成功,端口：" + serverPort);
    }


    @GetMapping("/query")
    public Result query() {
        List<Payment> result = paymentService.query();
        return new Result<>(200, "查询成功,端口：" + serverPort, result);
    }
}