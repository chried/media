package com.wolf.media.core.dao;

import com.wolf.media.core.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 定义顶级dao.
 *
 * @param <E> 实体类.
 * @author chried
 */
@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends JpaRepository<E, String> {
}
