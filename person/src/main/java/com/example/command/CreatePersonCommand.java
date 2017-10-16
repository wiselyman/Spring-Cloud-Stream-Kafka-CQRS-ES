package com.example.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wangyunfei on 2017/6/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonCommand {
    private String id;
    private String name;
    private Integer age;
    private Boolean gender;

}
