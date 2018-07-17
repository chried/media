package com.wolf.media.cache;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * token缓存.
 *
 * @author gaoweibing
 */
@RedisHash(value = "_token")
public class TokenCache implements Serializable {

    @Id
    private String id;
    /**
     * 用户id.
     */
    private String userId;

    /**
     * token令牌.
     */
    private String token;

    /**
     * 用户名.
     */
    private String username;

    /**
     * 名称.
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
