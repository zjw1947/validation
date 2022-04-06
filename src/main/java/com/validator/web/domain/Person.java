package com.validator.web.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author zjw
 * @createDate 2022-3-4
 */
@Data
public class Person {

    /** 主键 */
    @Null
    private String id;

    /** 姓名 */
    @NotNull(message = "不能为空")
    private String name;

    /** 出生日期 */
    @NotBlank
    private String birthday;

    /** 手机号 */

    private String phone;

    /** 邮箱 */
    private String email;
}
