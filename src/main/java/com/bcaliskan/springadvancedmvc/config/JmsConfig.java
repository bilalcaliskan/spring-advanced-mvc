package com.bcaliskan.springadvancedmvc.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    public static final String textMsgQueue = "text.messagequeue";

    @Bean
    public Queue textMessageQueue() {
        return new ActiveMQQueue(textMsgQueue);
    }

}