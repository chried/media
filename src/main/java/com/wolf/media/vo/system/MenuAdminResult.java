package com.wolf.media.vo.system;

import com.wolf.media.model.MenuEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 管理页面菜单返回结果.
 *
 * @author gaoweibing
 */
public class MenuAdminResult implements Serializable {

    /**
     * 菜单.
     */
    private MenuEntity menu;

    /**
     * 子菜单.
     */
    private List<MenuEntity> menus;

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}
