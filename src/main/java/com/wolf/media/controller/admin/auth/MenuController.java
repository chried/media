package com.wolf.media.controller.admin.auth;

import com.wolf.media.core.controller.AbstractController;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.MenuEntity;
import com.wolf.media.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoweibing
 */
@RestController("admin$auth$menu")
@RequestMapping(value = "menu")
public class MenuController extends AbstractController<MenuEntity> {

    @Autowired
    private MenuService menuService;

    /**
     * 获取service.
     *
     * @return
     */
    @Override
    public AbstractService<MenuEntity> getService() {
        return menuService;
    }
}
