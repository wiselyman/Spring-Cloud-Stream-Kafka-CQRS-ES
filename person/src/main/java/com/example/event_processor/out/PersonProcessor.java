package com.example.event_processor.out;

import com.example.config.KafkaBindings;
import com.example.domain.Person;
import com.example.event.PersonCountAddedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by wangyunfei on 2017/6/16.
 */
@Component
public class PersonProcessor {

    @Qualifier(KafkaBindings.PERSON_COUNT_OUT)
    @Autowired
    private MessageChannel personCountOut;

    @Async
    @TransactionalEventListener
    public void handleAfterPersonSavedComplete(PersonCountAddedEvent personCountAddedEvent){
        Message message  = MessageBuilder
                .withPayload(personCountAddedEvent)
                .setHeader("type","PersonCountAddedEvent")
                .build();

        personCountOut.send(message);
    }
}
