package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.AbstractEntity;

/**
 * 定义顶级service.
 *
 * @author chried
 */
public interface AbstractService<T extends AbstractEntity, S> {

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    ApiOutput<T> save(T entity);

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    T save_(T entity);
}
