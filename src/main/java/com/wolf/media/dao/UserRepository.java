package com.wolf.media.dao;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<UserEntity> {


    /**
     * 根据用户名获取用户.
     *
     * @param username 用户名.
     * @return 用户信息.
     */
    @Query("select u from UserEntity u where u.username = :username")
    UserEntity findByUsername(@Param("username") String username);

    /**
     * 根据用户名获取用户.
     *
     * @param username 用户名.
     * @param status_  状态.
     * @return
     */
    @Query("select u from UserEntity u where u.username = :username and u.extend.status_ = :status_")
    UserEntity findByUsername(String username, String status_);
}
