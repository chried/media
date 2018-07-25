package com.wolf.media.dao;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.model.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author gaoweibing
 */
@Repository
public interface MenuRepository extends AbstractRepository<MenuEntity> {


    /**
     * 查询.
     *
     * @param name     名称.
     * @param sign     标志.
     * @param status_  状态.
     * @param pageable 分页.
     * @return 分页信息.
     */
    @Query(value =
            "select m from MenuEntity  m" +
                    " where m.parentId = :parentId" +
                    " and m.name like :name " +
                    " and m.sign like :sign " +
                    " and m.extend.status_ = :status_")
    Page<MenuEntity> query(
            @Param("parentId") String parentId,
            @Param("name") String name,
            @Param("sign") String sign,
            @Param("status_") String status_, Pageable pageable);
}
