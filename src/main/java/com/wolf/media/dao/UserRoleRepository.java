package com.wolf.media.dao;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.model.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoweibing
 */
@Repository
public interface UserRoleRepository extends AbstractRepository<UserRoleEntity> {

    /**
     * 根据userId查询关联关系.
     *
     * @param userId  用户id.
     * @param status_ 状态.
     * @return 关系列表.
     */
    @Query("select u from UserRoleEntity u where u.userId = :userId " +
            " and u.extend.status_ = :status_")
    List<UserRoleEntity> queryByUserId(@Param("userId") String userId, @Param("status_") String status_);
}
