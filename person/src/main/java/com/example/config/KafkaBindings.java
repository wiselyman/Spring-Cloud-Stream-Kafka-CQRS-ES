package com.example.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by wangyunfei on 2017/6/16.
 */
public interface KafkaBindings {

    String PERSON_COUNT_OUT = "personCount";



    @Output(KafkaBindings.PERSON_COUNT_OUT)
    MessageChannel personCountOut();

}
