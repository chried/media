package com.wolf.media.service;


import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity, String> implements UserService {



    @Override
    public AbstractRepository<UserEntity, String> getRepository() {
        return null;
    }
}
