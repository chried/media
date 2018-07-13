package com.wolf.media.service;

import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.RoleEntity;

import java.util.List;

/**
 * @author chried
 */
public interface RoleService extends AbstractService<RoleEntity> {

    /**
     * 查询全部.
     *
     * @return 返回角色列表.
     */
    List<RoleEntity> queryAll();
}
