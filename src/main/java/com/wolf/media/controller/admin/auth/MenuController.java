package com.wolf.media.controller.admin.auth;

import com.wolf.media.core.apiout.PageListApiOutput;
import com.wolf.media.core.controller.AbstractController;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.dto.system.MenuQueryForm;
import com.wolf.media.model.MenuEntity;
import com.wolf.media.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoweibing
 */
@RestController("admin$auth$menu")
@RequestMapping(value = "admin/auth/menu")
public class MenuController extends AbstractController<MenuEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(MenuController.class);

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


    /**
     * query.
     *
     * @param form
     * @return
     */
    @PostMapping(value = "/query")
    public PageListApiOutput<MenuEntity> query(@RequestBody MenuQueryForm form) {

        LOG.info("菜单查询.");

        return menuService.query(form);
    }
}
