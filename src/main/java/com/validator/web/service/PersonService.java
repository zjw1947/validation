package com.validator.web.service;

import com.validator.web.domain.Person;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author zjw
 * @create 2022-04-12
 **/
//在service层校验需加入该注解， 改注解可以写在实现类上, 二选一
@Validated
public interface PersonService {

    //校验的主要需要写在接口层
    void add(@Valid Person person);

//    Person findById(@NotNull String id);
//    @NotNull Person findById(String id);
}
