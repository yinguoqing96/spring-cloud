package cn.yinguoqing.springcloud.controller;

import cn.yinguoqing.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yin Guoqing
 * @date 2022/10/21
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}