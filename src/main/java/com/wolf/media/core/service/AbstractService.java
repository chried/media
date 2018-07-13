package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.AbstractEntity;

/**
 * 定义顶级service.
 *
 * @author chried
 */
public interface AbstractService<E extends AbstractEntity> {


    /**
     * 新增.
     *
     * @param entity 对象.
     * @return 实体.
     */
    ApiOutput<E> add(E entity);

    /**
     * 新增.
     *
     * @param entity 对象.
     * @return 实体.
     */
    E add_(E entity);

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    ApiOutput<E> save(E entity);

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    E save_(E entity);

    /**
     * 修改.
     *
     * @param entity
     * @return
     */
    ApiOutput<E> modify(E entity);


    /**
     * 修改.
     *
     * @param entity
     * @return
     */
    E modify_(E entity);

    /**
     * 获取对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    ApiOutput<E> get(String id);

    /**
     * 获取对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    E get_(String id);


    /**
     * 初始化对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    ApiOutput<E> getOfEdit(String id);
}
