package com.validator.web.service.impl;

import com.validator.web.domain.Person;
import com.validator.web.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author zjw
 * @create 2022-04-12
 **/
@Service
//在service层校验需加入该注解， 改注解可以写在接口类上，二选一
//@Validated
public class PersonServiceImpl implements PersonService {

    @Override
    public void add(Person person) {

    }
}
