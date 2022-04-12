package com.validator.base.test;

import com.validator.base.domain.Basics;
import org.hibernate.validator.HibernateValidator;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 注解的使用
 * @author zjw
 * @create 2022-04-05
 **/
public class BaseTest {

    @Test
    public void paramTest() throws Exception{
        Basics basics = new Basics();
        basics.setId("123");
        basics.setName("张三");
        basics.setIdCard("012345678901234567");
        basics.setAge(12);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        basics.setBirthday(sdf.parse("2011-01-01"));

        basics.setPost("岗位:fdsf");
        basics.setEmail("3243@qq.com");
        basics.setPortrait("http://www.baidi.com");
        basics.setHobby("跑步");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //一个参数校验失败直接结束校验
//        Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
        //使用默认分组，不写默认Default.class
//        Set<ConstraintViolation<Basics>> set = validator.validate(basics, Default.class);
        Set<ConstraintViolation<Basics>> set = validator.validate(basics);
        if(!CollectionUtils.isEmpty(set)){
            set.stream().map(e -> e.getPropertyPath() + "：" + e.getMessage()).collect(Collectors.toList()).stream().forEach(System.err::println);
        }
    }

}
