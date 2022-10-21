package cn.yinguoqing.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.yinguoqing.springcloud.service.IMessageProvider;
import org.ietf.jgss.ChannelBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yin Guoqing
 * @date 2022/10/21
 */
@Service
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private StreamBridge streamBridge;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        streamBridge.send("myChannel-out-0", MessageBuilder.withPayload(serial).build());
        System.out.println("发送消息: " + serial);
        return null;
    }

}