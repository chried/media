package com.wolf.media.controller.admin.auth;


import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.service.RoleService;
import com.wolf.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author chried
 */
@RestController
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add")
    public Mono<RoleEntity> add() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode("10101");
        roleEntity.setName("管理员");
        roleEntity.setSign("Manager");
        return Mono.just(roleEntity);
    }
}
