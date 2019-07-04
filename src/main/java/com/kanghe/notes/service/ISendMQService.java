package com.kanghe.notes.service;

public interface ISendMQService {

    /**
     * 发送MQ消息
     *
     * @param topic 主题
     * @param tag   标签
     * @param body  内容
     * @return 响应结果
     */
    public Boolean send(String topic, String tag, String body);

}
