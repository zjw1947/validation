package com.validator.web.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@Data
public class Person {

    //新增组
    public interface Add{}
    //修改组
    public interface Edit{}

    /** 主键 */
    @Null(groups = Add.class)
    @NotNull(groups = {Edit.class})
    private String id;

    /** 姓名 */
    @NotNull(groups = {Edit.class, Add.class, Default.class})
    private String name;

    /** 出生日期 */
    @NotBlank
    private String birthday;

    //级联校验   该值为null是不校验
    @Valid
    private Student student;
//    private @Valid Student student;
}
