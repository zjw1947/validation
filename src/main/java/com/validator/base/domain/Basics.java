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
    //被注释的元素必须不为 null
    @NotNull  //(message = "主键别空着")
    private String id;

    /** 姓名 */
    //被注释的字符串（!=null && !""）、集合（size>0）
    @NotEmpty
    private String name;

    /** 证件号 */
    //被注释的字符串（!=null && !"" && !"   "）
    @NotBlank
    //被注释的元素的大小必须在指定范围内
    @Size(max = 18)
    private String idCard;

    /** 年龄 */
    //被注释的元素必须在合适的范围内      message使用el表达式
    @Range(min = 20, max = 60, message = "年龄值需在{min}和{max}之间")
    private Integer age;

    /** 出生日期 */
    //被注释的元素必须是一个过去的日期
    @Past
    private Date birthday;

    /** 岗位 */
    //被注释的元素必须符合执行的正则表达式
    @Pattern(regexp = "^岗位:.*$")
    private String post;

    /** 邮箱 */
    //被注释的元素必须是电子邮件地址
    @Email
    private String email;

    /** 头像 */
    //被注释的元素必须的是一个url地址
    @URL
    private String portrait;

    /** 爱好 */
    //自定义注解
    @Hobby
    private String hobby;

    /** 手机号 */
    private String phone;

}
