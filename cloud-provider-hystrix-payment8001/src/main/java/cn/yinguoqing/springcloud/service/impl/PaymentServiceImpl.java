package cn.yinguoqing.springcloud.service.impl;

import cn.yinguoqing.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Yin Guoqing
 * @date 2022/9/15
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Value("${server.port}")
    private String serverPort;

    @Override
    public String success(Integer id) {
        String message = "success:   serverPort: " + serverPort + " id: " + id + "线程：" + Thread.currentThread().getName();
        System.out.println(message);
        return message;
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String timeout(Integer id) {
        int timeNumber = 5000;
        try {
            int i = 0/10;
            Thread.sleep(timeNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = "timeout:   serverPort: " + serverPort + " id: " + id + " 耗时（毫秒）：" + timeNumber + "  线程：" + Thread.currentThread().getName();
        System.out.println(message);
        return message;
    }

    public String timeout_handler(Integer id) {
        return "id: " + id + "  线程：" + Thread.currentThread().getName() + " timeout_handler....";
    }
}