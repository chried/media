package com.wolf.media.dao;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<UserEntity, String> {
}
