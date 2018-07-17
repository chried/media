package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户实体类.
 *
 * @author chried
 */
@Entity
@Table(schema = "m_system", name = "s_user")
@AttributeOverride(name = "id", column = @Column(name = "u_id", updatable = false, length = 40))
public class UserEntity extends AbstractEntity {

    /**
     * 用户编号，全球唯一.
     */
    @Column(name = "u_code", length = 15)
    private String code;

    /**
     * 名称.
     */
    @Column(name = "u_name", length = 20)
    private String name;

    /**
     * 用户名.
     */
    @Column(name = "u_username", length = 20)
    private String username;

    /**
     * 密码.
     */
    @Column(name = "u_password", length = 50)
    private String password;

    /**
     * 头像.
     */
    @Column(name = "u_portrait", length = 200)
    private String portrait;

    /**
     * 电子邮箱.
     */
    @Column(name = "u_email")
    private String email;

    /**
     * 电话.
     */
    @Column(name = "u_phone", length = 20)
    private String phone;

    /**
     * 锁定时间.
     */
    @Column(name = "u_lock")
    private LocalDateTime lock;

    /**
     * 一个用户可能多个角色.
     */
    @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.ALL}, targetEntity = RoleEntity.class)
    private List<RoleEntity> roles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getLock() {
        return lock;
    }

    public void setLock(LocalDateTime lock) {
        this.lock = lock;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
