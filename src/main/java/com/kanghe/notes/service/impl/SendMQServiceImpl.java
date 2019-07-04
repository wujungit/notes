package com.kanghe.notes.service.impl;

import com.kanghe.notes.enums.ResultEnum;
import com.kanghe.notes.exception.BuzException;
import com.kanghe.notes.service.ISendMQService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class SendMQServiceImpl implements ISendMQService {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Override
    public Boolean send(String topic, String tag, String body) {
        try {
            Message message = new Message();
            message.setTopic(topic);
            message.setTags(tag);
            message.setBody(body.getBytes(StandardCharsets.UTF_8));
            SendResult result = defaultMQProducer.send(message);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuzException(ResultEnum.SEND_MQ_ERROR);
        }
    }

}
