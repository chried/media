package com.wolf.media.service;

import com.wolf.media.core.service.AbstractService;
import com.wolf.media.model.AuthorityEntity;

import java.util.List;

/**
 * @author chried
 */
public interface AuthorityService extends AbstractService<AuthorityEntity> {

    /**
     * 查询所有.
     *
     * @return 返回列表.
     */
    List<AuthorityEntity> queryAll();
}
