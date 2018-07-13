package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.entity.AbstractEntity;
import com.wolf.media.core.entity.EntityParameter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 定义实现类.
 *
 * @author chried
 */
public abstract class AbstractServiceImpl<E extends AbstractEntity> implements AbstractService<E> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractServiceImpl.class);

    /**
     * 获取Repository.
     *
     * @return
     */
    public abstract AbstractRepository<E> getRepository();

    /**
     * 获取class.
     */
    public abstract Class<E> getClazz();

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    @Override
    public ApiOutput<E> save(E entity) {
        return ApiOutput.of(this.save_(entity));
    }

    /**
     * 保存.
     *
     * @param entity 实体类.
     * @return 返回对象.
     */
    @Override
    public E save_(E entity) {

        if (StringUtils.isNotBlank(entity.getId())) {
            return this.modify_(entity);
        } else {
            return this.add_(entity);
        }
    }

    /**
     * 新增.
     *
     * @param entity 对象.
     * @return 实体.
     */
    @Override
    public ApiOutput<E> add(E entity) {

        return ApiOutput.of(this.add_(entity));
    }

    /**
     * 新增.
     *
     * @param entity 对象.
     * @return 实体.
     */
    @Override
    @Transactional
    public E add_(E entity) {

        entity.setId(UUID.randomUUID().toString());
        //当前数据版本1.
        entity.setVersion(1);
        entity.setInsert_(LocalDateTime.now());
        entity.setUpdate_(entity.getInsert_());
        entity.setDelete_(entity.getInsert_());
        entity.setStatus_(EntityParameter.ACTIVE_);

        return this.getRepository().save(entity);
    }

    /**
     * 修改.
     *
     * @param entity
     * @return
     */
    @Override
    public ApiOutput<E> modify(E entity) {

        return ApiOutput.of(this.modify_(entity));
    }

    /**
     * 修改.
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public E modify_(E entity) {

        entity.setUpdate_(LocalDateTime.now());

        return this.getRepository().save(entity);
    }

    /**
     * 获取对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    @Override
    public ApiOutput<E> get(String id) {

        return ApiOutput.of(this.get_(id));
    }

    /**
     * 获取对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    @Override
    public E get_(String id) {

        return this.getRepository().getOne(id);

    }

    /**
     * 初始化对象.
     *
     * @param id 主键ID.
     * @return 对象.
     */
    @Override
    public ApiOutput<E> getOfEdit(String id) {

        if (StringUtils.isNotBlank(id)) {
            return this.get(id);
        }

        E e = null;

        try {
            e = this.getClazz().getConstructor().newInstance();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }

        return ApiOutput.of(e);

    }
}
