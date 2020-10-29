package com.hotfan.mqtt.controller;

/**
 * @author guigui
 * @create 2020-10-28 19:03
 */
import com.hotfan.mqtt.sender.IMqttSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * 注入发送MQTT的Bean
     */
    @Autowired
    private IMqttSender iMqttSender;

    // 发送自定义消息内容（使用默认主题）
    @RequestMapping("/test1/{data}")
    public void test1(@PathVariable("data") String data) {
        iMqttSender.sendToMqtt(data);
    }

    // 发送自定义消息内容，且指定主题
    @RequestMapping("/test2/{topic}/{data}")
    public void test2(@PathVariable("topic") String topic, @PathVariable("data") String data) {
        iMqttSender.sendToMqtt(topic, data);
    }
}
