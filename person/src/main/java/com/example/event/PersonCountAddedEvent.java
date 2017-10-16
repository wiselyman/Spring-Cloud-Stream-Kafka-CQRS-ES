package com.example.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wangyunfei on 2017/6/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonCountAddedEvent {

    private Long num;
}
