package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.AbstractEntity;

import java.util.Collection;

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

    /**
     * 假删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    ApiOutput<Integer> remove(String id);

    /**
     * 假删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    int remove_(String id);

    /**
     * 批量假删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    ApiOutput<Integer> removeBatch(Collection<String> ids);

    /**
     * 批量假删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    int removeBatch_(Collection<String> ids);

    /**
     * 批量删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    ApiOutput<Integer> deleteBatch(Collection<String> ids);

    /**
     * 批量删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    int deleteBatch_(Collection<String> ids);

    /**
     * 删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    ApiOutput<Integer> delete(String id);

    /**
     * 删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    int delete_(String id);
}
