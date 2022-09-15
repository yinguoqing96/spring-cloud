package cn.yinguoqing.springcloud.service.impl;

import cn.yinguoqing.springcloud.entity.Payment;
import cn.yinguoqing.springcloud.mapper.PaymentMapper;
import cn.yinguoqing.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yinguoqing
 * @date 2022/9/15
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public List<Payment> query() {
        return paymentMapper.selectList(null);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getId(Long id) {
        return paymentMapper.selectById(id);
    }
}