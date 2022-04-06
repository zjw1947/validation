package com.validator.web.controller;

import com.validator.web.domain.Person;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@RestController
@RequestMapping("person")
@Validated
public class PersonController {
/*

    @ExceptionHandler
    public Object exceptionHandler(ConstraintViolationException e){
        return e;
    }
*/

    @PostMapping("test")
    public Object test(@RequestBody @Valid Person person, BindingResult results){
//
        /*if(results.hasErrors()){
//            return "请求参数异常,错误信息为:" + results.getFieldError().getDefaultMessage();
            return results.getFieldErrors();
        }*/
        return "null";
    }

}
