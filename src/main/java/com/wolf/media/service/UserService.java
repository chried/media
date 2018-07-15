package com.wolf.media.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.service.AbstractService;
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
}
