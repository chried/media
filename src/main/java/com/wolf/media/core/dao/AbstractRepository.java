package com.wolf.media.core.dao;

import com.wolf.media.core.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定义顶级dao.
 *
 * @param <E>  实体类.
 * @param <ID> 主键类型.
 * @author chried
 */
public interface AbstractRepository<E extends AbstractEntity, ID> extends JpaRepository<AbstractEntity, String> {
}
