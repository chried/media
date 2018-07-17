package com.wolf.media.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录form.
 *
 * @author gaoweibing
 */
public class LoginForm implements Serializable {

    /**
     * 用户名.
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码.
     */
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 验证码.
     */
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
