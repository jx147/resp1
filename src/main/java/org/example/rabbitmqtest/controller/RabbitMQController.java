package org.example.rabbitmqtest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.rabbitmqtest.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/rabbitmq")
@Tag(name = "RabbitMQ 测试接口", description = "用于测试 RabbitMQ 消息发送和接收")
public class RabbitMQController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    @Operation(summary = "发送文本消息", description = "向 RabbitMQ 队列发送一条文本消息")
    public Map<String, Object> sendMessage(@RequestParam String message) {
        messageProducer.sendMessage(message);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "消息发送成功");
        result.put("data", message);
        return result;
    }

    @PostMapping("/send/object")
    @Operation(summary = "发送对象消息", description = "向 RabbitMQ 队列发送一个对象消息")
    public Map<String, Object> sendObjectMessage(@RequestBody Map<String, Object> data) {
        messageProducer.sendObjectMessage(data);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "对象消息发送成功");
        result.put("data", data);
        return result;
    }
}
