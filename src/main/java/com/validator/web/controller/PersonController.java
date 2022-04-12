package com.validator.web.controller;

import com.validator.base.domain.Basics;
import com.validator.web.api.ApiResult;
import com.validator.web.domain.Person;
import org.graalvm.compiler.nodes.NodeView;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@RestController
@RequestMapping("person")
//整个类启用校验，若参数中含有 bean validation 注解的会自动校验
@Validated
public class PersonController {

    /**
     * 捕获该控制器内的指定异常进行处理, 不使用BindingResult接收错误时使用
     */
    /*@ExceptionHandler(value = BindException.class)
    public ApiResult exceptionHandler(BindException ex){
        return ApiResult.error(ex.getBindingResult());
    }*/


    /**
     * 手动校验
     */
    @PostMapping("add")
    public ApiResult add(@RequestBody Person person) {
        Set<ConstraintViolation<Person>> set = Validation.buildDefaultValidatorFactory().getValidator().validate(person);
        if (!CollectionUtils.isEmpty(set)) {
            return new ApiResult().failure(set.stream().map(e -> e.getPropertyPath() + "：" + e.getMessage()).collect(Collectors.toList()));
        }
        return new ApiResult().success();
    }


    /**
     * 会直接系统报错
     */
    @PostMapping("add1")
    public ApiResult add1(@RequestBody @Valid Person person) {
        return new ApiResult().success();
    }

    /**
     * 获取错误信息并自定义处理
     */
    @PostMapping("add2")
    public ApiResult add2(@RequestBody @Valid Person person, BindingResult results) {
        if (results.hasErrors()) {
            return ApiResult.error(results);
        }
        return new ApiResult().success();
    }

    /**
     * 级联校验
     */
    @PostMapping("add3")
    public ApiResult add3(@RequestBody @Validated(value = {Person.Add.class}) Person person, BindingResult results) {
        if (results.hasErrors()) {
            return ApiResult.error(results);
        }
        return new ApiResult().success();
    }

    /**
     * 分组校验
     * @Validated 使用spring提供的该注解进行分组校验
     * 不指定组的情况下默认 Default.class 组，
     * 指明组的情况下会覆盖 Default 组，要想使用需手动添加
     */
    @PostMapping("add4")
    public ApiResult add4(@RequestBody @Validated(value = {Person.Add.class}) Person person, BindingResult results) {
//    public ApiResult add4(@RequestBody @Validated(value = {Person.Add.class, Default.class}) Person person, BindingResult results) {
        if (results.hasErrors()) {
            return ApiResult.error(results);
        }
        return new ApiResult().success();
    }

    /**
     * 校验参数
     * 需要类上加 @Validated 注解，改方式不能通过BindingResult获得错误信息
     * 可通过捕获 ConstraintViolationException 异常获取错误信息
     */
    @GetMapping("find")
    public ApiResult find(@NotBlank String name) {
        return new ApiResult().success();
    }

    /**
     * 校验返回值
     * 需要类上加 @Validated 注解，改方式不能通过BindingResult获得错误信息
     * 可通过捕获 ConstraintViolationException 异常获取错误信息
     */
    @GetMapping("find1")
    public @NotNull ApiResult find1() {
        return null;
    }
}
