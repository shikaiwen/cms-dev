package com.issoh.entity.tk;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 0、禁用 1、正常
     */
    private Boolean type;

    /**
     * 自定义填充的创建时间
     */
    private Date ctime;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户年龄
     *
     * @return age - 用户年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置用户年龄
     *
     * @param age 用户年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取0、禁用 1、正常
     *
     * @return type - 0、禁用 1、正常
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置0、禁用 1、正常
     *
     * @param type 0、禁用 1、正常
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取自定义填充的创建时间
     *
     * @return ctime - 自定义填充的创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置自定义填充的创建时间
     *
     * @param ctime 自定义填充的创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}