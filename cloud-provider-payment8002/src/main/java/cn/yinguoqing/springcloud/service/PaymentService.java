package cn.yinguoqing.springcloud.service;

import cn.yinguoqing.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
public interface PaymentService {
    List<Payment> query();

    int create(Payment payment);

    Payment getId(Long id);
}