package com.wolf.media.dao;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.model.RoleMenuEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoweibing
 */
@Repository
public interface RoleMenuRepository extends AbstractRepository<RoleMenuEntity> {


    /**
     * 根据userId查询.
     *
     * @param userId  用户id.
     * @param status_ 状态.
     * @return roleMenu关系列表.
     */
    @Query("select r from RoleMenuEntity r where r.roleId in (" +
            " select u.roleId from UserRoleEntity u where u.userId = :userId) and r.extend.status_ = :status_")
    List<RoleMenuEntity> queryByUserId(@Param("userId") String userId, @Param("status_") String status_);

}
