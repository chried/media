package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.entity.AbstractEntity;

/**
 * 定义实现类.
 *
 * @author chried
 */
public abstract class AbstractServiceImpl<E extends AbstractEntity, ID> implements AbstractService {

    public abstract AbstractRepository<E, ID> getRepository();

    @Override
    public ApiOutput save(AbstractEntity entity) {
        return ApiOutput.of(this.save_(entity));
    }

    @Override
    public AbstractEntity save_(AbstractEntity entity) {
        AbstractEntity save = this.getRepository().save(entity);
        return save;
    }
}
