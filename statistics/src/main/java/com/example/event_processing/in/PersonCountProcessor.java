package com.example.event_processing.in;

import com.example.config.KafkaBindings;
import com.example.event.PersonCountAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by wangyunfei on 2017/6/16.
 */
@Component
@Slf4j
public class PersonCountProcessor {

    @StreamListener(target = KafkaBindings.PERSON_COUNT_IN ,condition ="PersonCountAddedEvent")
    public void updatePerson(@Payload PersonCountAddedEvent event){
        log.info("*******" + event.getNum() + "*******");
    }
}
