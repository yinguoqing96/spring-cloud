package cn.yinguoqing.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yin Guoqing
 * @date 2022/10/31
 */
@RestController
@RefreshScope // 支持nacos的动态刷新功能
public class ConfigClientController {

    @Value("${configInfo}")
    private String configInfo;


    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}