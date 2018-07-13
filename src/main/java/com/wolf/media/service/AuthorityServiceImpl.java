package com.wolf.media.service;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.AuthorityRepository;
import com.wolf.media.model.AuthorityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chried
 */
@Service
public class AuthorityServiceImpl extends AbstractServiceImpl<AuthorityEntity> implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * 获取Repository.
     *
     * @return
     */
    @Override
    public AbstractRepository<AuthorityEntity> getRepository() {
        return authorityRepository;
    }

    /**
     * 获取class.
     */
    @Override
    public Class<AuthorityEntity> getClazz() {
        return AuthorityEntity.class;
    }

    /**
     * 查询所有.
     *
     * @return 返回列表.
     */
    @Override
    public List<AuthorityEntity> queryAll() {
        return authorityRepository.findAll();
    }
}
