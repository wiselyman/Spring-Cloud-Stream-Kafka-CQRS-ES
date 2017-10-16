package com.example.repository;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangyunfei on 2017/6/5.
 */
public interface PersonRepository  extends JpaRepository<Person,String>{
}
