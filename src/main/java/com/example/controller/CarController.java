package com.example.controller;

import com.example.domain.Car;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@RestController
@RequestMapping("car")
public class CarController {

    @GetMapping("test")
    public Object test(@Valid Car car, BindingResult results){
        if(results.hasErrors()){
            return "请求参数异常,错误信息为:" + results.getFieldError().getDefaultMessage();
        }
        return "null";
    }

}
