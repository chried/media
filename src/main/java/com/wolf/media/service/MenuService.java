package com.wolf.media.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.MenuEntity;

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
}
