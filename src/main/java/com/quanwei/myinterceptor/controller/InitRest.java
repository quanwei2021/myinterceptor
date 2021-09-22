package com.quanwei.myinterceptor.controller;

import com.quanwei.myinterceptor.config.MyTopics;
import com.quanwei.myinterceptor.dao.OrderPaidEvent;
import com.zc.smartcity.rocketmq.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;

@RestController
public class InitRest {
    protected static Logger logger = LoggerFactory.getLogger(Integer.class);
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/sendMsgText")
    public String sendMsgText() {
        // 发送普通文本消息
        String msg = "Hello，World，spring-boot2-rocketmq! flag=" + new Random().nextInt(100);
        String destination1 = MyTopics.TOPIC1 + ":" + MyTopics.TAG1;
        rocketMQTemplate.convertAndSend(destination1, msg);
        logger.info("sendMsg success。发送普通文本消息 msg=" + msg);
        return "success for text";
    }


    @RequestMapping("/sendMsgObj")
    public String sendMsgObj() {
        // 发送对象数据消息
        OrderPaidEvent order = new OrderPaidEvent("T_001_ID_" + new Random().nextInt(100), new BigDecimal("88.00"));
        String destination2 = MyTopics.TOPIC1 + ":" + MyTopics.TAG2;
        rocketMQTemplate.convertAndSend(destination2, order);
        logger.info("sendMsg success。发送对象消息 order=" + order.toString());

        return "success for obj";
    }

}
