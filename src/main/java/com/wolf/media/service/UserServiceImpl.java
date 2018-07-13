package com.wolf.media.service;


import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.UserRepository;
import com.wolf.media.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity> implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取Repository.
     *
     * @return
     */
    @Override
    public AbstractRepository<UserEntity> getRepository() {
        return userRepository;
    }

    /**
     * 获取class.
     */
    @Override
    public Class<UserEntity> getClazz() {
        return UserEntity.class;
    }

}
