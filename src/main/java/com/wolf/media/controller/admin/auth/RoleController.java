package com.wolf.media.controller.admin.auth;


import com.wolf.media.core.controller.AbstractController;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.service.RoleService;
import com.wolf.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chried
 */
@RestController("admin$auth$role")
@RequestMapping(value = "role")
public class RoleController extends AbstractController<RoleEntity> {

    @Autowired
    private RoleService roleService;

    /**
     * 获取service.
     *
     * @return
     */
    @Override
    public AbstractService<RoleEntity> getService() {
        return roleService;
    }
}
