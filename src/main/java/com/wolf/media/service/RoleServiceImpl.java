package com.wolf.media.service;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.RoleRepository;
import com.wolf.media.model.RoleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<RoleEntity> implements RoleService {

    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 获取Repository.
     *
     * @return
     */
    @Override
    public AbstractRepository<RoleEntity> getRepository() {
        return roleRepository;
    }

    /**
     * 获取class.
     */
    @Override
    public Class<RoleEntity> getClazz() {
        return RoleEntity.class;
    }

    /**
     * 查询全部.
     *
     * @return 返回角色列表.
     */
    @Override
    public List<RoleEntity> queryAll() {
        return this.roleRepository.findAll();
    }
}
