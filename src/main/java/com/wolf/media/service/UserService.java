package com.wolf.media.service;

import com.wolf.media.cache.TokenCache;
import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.dto.LoginForm;
import com.wolf.media.model.UserEntity;

import java.util.Collection;

/**
 * @author chried
 */
public interface UserService extends AbstractService<UserEntity> {

    /**
     * 授权.
     *
     * @param roleIds 角色ID.
     * @return 成功标记.
     */
    ApiOutput<String> authorizeRole(Collection<String> roleIds);

    /**
     * 用户登录.
     *
     * @param form 登录模型.
     * @return token信息.
     */
    ApiOutput<TokenCache> loginByName(LoginForm form);

    
}
