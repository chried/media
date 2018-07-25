package com.wolf.media.service;

import com.wolf.media.core.apiout.PageListApiOutput;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.dto.system.MenuQueryForm;
import com.wolf.media.model.MenuEntity;
import com.wolf.media.vo.system.MenuAdminResult;

import java.util.List;

/**
 * @author gaoweibing
 */
public interface MenuService extends AbstractService<MenuEntity> {

    /**
     * 获取当前用户拥有的菜单.
     *
     * @param userId 用户id.
     * @return 菜单列表.
     */
    List<MenuEntity> getCurrentMenu_(String userId);

    /**
     * 获取用户菜单.
     *
     * @param userId 用户id.
     * @return 菜单列表.
     */
    List<MenuAdminResult> getAdminMenus_(String userId);

    /**
     * 查询.
     *
     * @param form
     * @return
     */
    PageListApiOutput<MenuEntity> query(MenuQueryForm form);
}
