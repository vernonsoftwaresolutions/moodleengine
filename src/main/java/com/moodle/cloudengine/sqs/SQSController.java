package com.moodle.cloudengine.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrewlarsen on 6/4/17.
 */
@RestController
public class SQSController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/worker/queue")
    public HttpStatus consumeMessage(@RequestBody SQSMessage message){
        logger.info("SQSMessage received ", message);
        return HttpStatus.OK;
    }


}
