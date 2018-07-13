package com.wolf.media.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.UserEntity;

public interface UserService extends AbstractService<UserEntity> {

    /**
     * 授权.
     *
     * @return 成功标记.
     */
    ApiOutput<String> authorizeRole();
}
