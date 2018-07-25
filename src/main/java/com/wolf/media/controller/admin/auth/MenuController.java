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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaoweibing
 */
@Controller("admin$auth$menu")
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
     * 跳转页面;
     *
     * @param id
     * @return
     */
    @GetMapping(value = "getMenu")
    public String getMenu(@RequestParam(value = "id") String id, Model model) {

        model.addAttribute("menu", this.menuService.get_(id));
        return "admin/system/addMenu";

    }

    /**
     * query.
     *
     * @param form
     * @return
     */
    @PostMapping(value = "/query")
    @ResponseBody
    public PageListApiOutput<MenuEntity> query(@RequestBody MenuQueryForm form) {

        return menuService.query(form);
    }


}
