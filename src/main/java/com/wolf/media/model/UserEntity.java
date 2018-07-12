package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "u_id"))
})
public class UserEntity extends AbstractEntity {

    /**
     * 用户编号，全球唯一.
     */
    @Column(name = "u_code")
    private String code;

    /**
     * 名称.
     */
    @Column(name = "u_name")
    private String name;

    /**
     * 用户名.
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码.
     */
    @Column(name = "password")
    private String password;

    /**
     * 头像.
     */
    @Column(name = "u_portrait")
    private String portrait;

    /**
     * 电子邮箱.
     */
    @Column(name = "u_email")
    private String email;

    /**
     * 电话.
     */
    @Column(name = "u_phone")
    private String phone;
    /**
     * 锁定时间.
     */
    @Column(name = "u_lock")
    private LocalDateTime lock;
}
