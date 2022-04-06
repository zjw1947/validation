package com.validator.base.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义校验注解
 * @author zjw
 * @create 2022-04-06
 **/
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//指明通过哪个类去定义校验规则
@Constraint(validatedBy = {HobbyValidator.class})
public @interface Hobby {

    //默认提示信息
    String message() default "爱好不行";

    //分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
