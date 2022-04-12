package com.validator.web.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zjw
 * @create 2022-04-07
 **/
@Data
public class Student {

    @NotNull
    private String id;

    @NotBlank
    private String name;

}
