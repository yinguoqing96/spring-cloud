package cn.yinguoqing.springcloud.service;

/**
 * @author Yin Guoqing
 * @date 2022/9/14
 */
public interface PaymentService {
    String success(Integer id);

    String timeout(Integer id);
}