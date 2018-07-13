package com.wolf.media.controller;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.model.UserEntity;
import com.wolf.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add")
    public ApiOutput<UserEntity> add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCode("10201201");
        userEntity.setName("chried");
        userEntity.setUsername("chried");
        ApiOutput<UserEntity> save = userService.save(userEntity);
        return save;
    }
}
