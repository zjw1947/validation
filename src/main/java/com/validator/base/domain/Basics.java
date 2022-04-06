package com.validator.base.domain;

import com.validator.base.annotation.Hobby;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author zjw
 * @create 2022-04-05
 **/
@Data
public class Basics {

    /** 主键 */
    @NotNull  //(message = "主键别空着")
    private String id;

    /** 姓名 */
    @NotEmpty
    private String name;

    /** 证件号 */
    @NotBlank
    @Size(max = 18)
    private String idCard;

    /** 年龄 */
    @Range(min = 20, max = 60)
    private Integer age;

    @Past
    private Date birthday;

    /** 岗位 */
    @Pattern(regexp = "^岗位:.*$")
    private String post;

    /** 邮箱 */
    @Email
    private String email;

    /** 头像 */
    @URL
    private String portrait;

    /** 爱好 */
    @Hobby
    private String hobby;

    /** 手机号 */
    private String phone;

}
