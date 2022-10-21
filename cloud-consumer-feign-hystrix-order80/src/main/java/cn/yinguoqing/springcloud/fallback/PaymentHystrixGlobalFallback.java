package cn.yinguoqing.springcloud.fallback;

import cn.yinguoqing.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author Yin Guoqing
 * @date 2022/10/13
 */
@Component
public class PaymentHystrixGlobalFallback implements PaymentHystrixService {

    @Override
    public String success(Integer id) {
        return "PaymentHystrixGlobalFallback success";
    }

    @Override
    public String timeout(Integer id) {
        return "PaymentHystrixGlobalFallback timeout";
    }
}