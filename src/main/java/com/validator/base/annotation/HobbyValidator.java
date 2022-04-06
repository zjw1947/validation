package com.validator.base.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验注解规则实现
 * @author zjw
 * @create 2022-04-06
 *
 * Hobby 是要处理的注解
 * CharSequence 是要处理的类型
 **/
public class HobbyValidator implements ConstraintValidator<Hobby, CharSequence> {
    @Override
    public void initialize(Hobby constraintAnnotation) {

    }

    /**
     * 校验规则方法
     */
    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null) {
            return true;
        }
        return "跑步游泳拳击".indexOf(charSequence.toString().trim()) > -1;
    }
}
