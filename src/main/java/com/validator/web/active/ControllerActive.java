package com.validator.web.active;

import com.validator.web.api.ApiResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 * @author zjw
 * @create 2022-04-07
 **/
//basePackages 可以不指定，表示应用到整个项目
//建议指定，性能更好
@ControllerAdvice(basePackages = "com.validator.web.controller")
@ResponseBody
public class ControllerActive {

    // @Validated 在方法上
    @ExceptionHandler(value = BindException.class)

    public ApiResult exceptionHandler(BindException ex){
        return ApiResult.error(ex.getBindingResult());
    }

    //  @Validated 在类上
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ApiResult exceptionHandler(ConstraintViolationException ex){
        return new ApiResult().failure(ex.getConstraintViolations().stream().map(e -> e.getPropertyPath() + "：" + e.getMessage()).collect(Collectors.toList()).stream());
    }

}
