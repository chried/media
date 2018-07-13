package com.wolf.media.core.dao;

import com.wolf.media.core.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 定义顶级实现.
 *
 * @author chried
 */
public class AbstractRepositoryImpl<E extends AbstractEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractRepositoryImpl.class);

    /**
     * 实体管理器.
     * <pre>
     * 按照微服务的设计思想，原则上一个项目只引用一个数据源，只访问一个数据库.
     * </pre>
     */
    @PersistenceContext
    protected EntityManager em;
}
