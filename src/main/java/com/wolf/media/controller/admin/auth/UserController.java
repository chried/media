package com.wolf.media.controller.admin.auth;

import com.wolf.media.core.controller.AbstractController;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.UserEntity;
import com.wolf.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chried
 */
@RestController("admin$auth$user")
@RequestMapping(value = "user")
public class UserController extends AbstractController<UserEntity> {

    @Autowired
    private UserService userService;

    /**
     * 获取service.
     *
     * @return
     */
    @Override
    public AbstractService<UserEntity> getService() {
        return userService;
    }
}
