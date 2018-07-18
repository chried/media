package com.wolf.media.core.service;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.entity.AbstractEntity;
import com.wolf.media.core.entity.EntityParameter;
import com.wolf.media.core.entity.Extend;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

/**
 * 定义实现类.
 *
 * @author chried
 */
public abstract class AbstractServiceImpl<E extends AbstractEntity> implements AbstractService<E> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractServiceImpl.class);

    /**
     * 实体管理器.
     * <pre>
     * 按照微服务的设计思想，原则上一个项目只引用一个数据源，只访问一个数据库.
     * </pre>
     */
    @PersistenceContext
    protected EntityManager em;

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
    @Transactional
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
        entity.getExtend().setVersion(1);
        LocalDateTime currentTime = LocalDateTime.now();
        entity.getExtend().setInsert_(currentTime);
        entity.getExtend().setUpdate_(currentTime);
        entity.getExtend().setDelete_(currentTime);
        entity.getExtend().setStatus_(EntityParameter.ACTIVE_);

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

        entity.getExtend().setUpdate_(LocalDateTime.now());

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

    /**
     * 假删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public ApiOutput<Integer> remove(String id) {

        return ApiOutput.of(this.remove_(id));

    }

    /**
     * 假删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public int remove_(String id) {

        E e = this.get_(id);
        Extend extend = e.getExtend();
        extend.setStatus_(EntityParameter.REMOVE);
        e.setExtend(extend);

        this.getRepository().save(e);

        return 1;

    }

    /**
     * 批量假删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public ApiOutput<Integer> removeBatch(Collection<String> ids) {

        return ApiOutput.of(this.removeBatch_(ids));

    }

    /**
     * 批量假删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public int removeBatch_(Collection<String> ids) {

        StringBuilder sb = new StringBuilder();

        for (String id : ids) {
            sb.append("'" + id + "'" + ",");
        }

        String sql = "UPDATE " + this.getClazz().getName() + " E SET E.extend.status_='" +
                EntityParameter.REMOVE + "' WHERE E.id in (" + sb.substring(0, sb.length() - 1) + ")";

        Query query = em.createQuery(sql);

        return query.executeUpdate();
    }

    /**
     * 批量删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public ApiOutput<Integer> deleteBatch(Collection<String> ids) {

        return ApiOutput.of(this.deleteBatch_(ids));

    }

    /**
     * 批量删除.
     *
     * @param ids 主键IDS.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public int deleteBatch_(Collection<String> ids) {

        StringBuilder sb = new StringBuilder();

        for (String id : ids) {
            sb.append("'" + id + "'" + ",");
        }

        String sql = "DELETE " + this.getClazz().getName() + " E WHERE E.id IN (" + sb.substring(0, sb.length() - 1) + ")";

        Query query = em.createQuery(sql);

        return query.executeUpdate();

    }

    /**
     * 删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public ApiOutput<Integer> delete(String id) {

        return ApiOutput.of(this.delete_(id));

    }

    /**
     * 删除.
     *
     * @param id 主键ID.
     * @return 删除个数.
     */
    @Override
    @Transactional
    public int delete_(String id) {

        this.getRepository().deleteById(id);

        return 1;

    }

    /**
     * 获取表名.
     *
     * @return 表名.
     */
    private String getTableName() {

        Table table = this.getClazz().getAnnotation(Table.class);

        return table.name();
    }

    /**
     * 获取主键ID.
     *
     * @return 主键id.
     */
    private String getId() {

        AttributeOverride attributeOverride = this.getClazz().getAnnotation(AttributeOverride.class);

        if (attributeOverride == null) {
            return "id";
        }

        return attributeOverride.column().name();

    }

}
