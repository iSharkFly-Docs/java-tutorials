package com.ossez.artemis.client.controller;

import com.ossez.artemis.client.JmsProducer;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

/**
 * 承包商相关 API
 *
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(MQController.BASE_URL)
public class MQController {

    protected static final String BASE_URL = "/mq";

    private final JmsProducer jmsProducer;

    @PostMapping("/send")
    public String addContractorInfo(@RequestBody String request) {
        jmsProducer.send(request);

        return "Send";
    }


}
