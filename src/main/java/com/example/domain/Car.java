package com.example.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@Data
public class Car {

    @NotNull(message = "不能为空")
    private String name;

}
