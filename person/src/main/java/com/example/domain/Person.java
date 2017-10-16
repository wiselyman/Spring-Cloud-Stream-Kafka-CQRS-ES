package com.example.domain;

import com.example.command.CreatePersonCommand;
import com.example.event.PersonCountAddedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wangyunfei on 2017/6/2.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    private Boolean gender;



    @DomainEvents
    Collection<Object> domainEvents(){
        List<Object> events= new ArrayList<Object>();
        PersonCountAddedEvent personCountAddedEvent = new PersonCountAddedEvent(1l);
        events.add(personCountAddedEvent);
        return events;
    }


    public Person(CreatePersonCommand personCommand) {
        BeanUtils.copyProperties(personCommand,this);
    }

}
