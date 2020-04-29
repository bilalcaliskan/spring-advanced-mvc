package com.bcaliskan.springadvancedmvc.services.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TextMessageListener {

    @JmsListener(destination = "text.messagequeue")
    public void onMessage(String msg) {
        log.info("######################################################");
        log.info("######################################################");
        log.info("I GOT A MESSAGE");
        log.info(msg);
        log.info("######################################################");
        log.info("######################################################");
    }

}