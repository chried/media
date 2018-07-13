package com.wolf.media.service;


import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.UserRepository;
import com.wolf.media.model.AuthorityEntity;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chried
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

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

    /**
     * 授权.
     *
     * @return 成功标记.
     */
    @Override
    @Transactional
    public ApiOutput<String> authorizeRole() {

        List<RoleEntity> roleEntities = this.roleService.queryAll();
        UserEntity userEntity = this.get_("0b2e82bf-3b0c-4e3e-869f-110d3a53a835");
        userEntity.setRoles(roleEntities);
        this.save(userEntity);

        return ApiOutput.of("操作成功");
    }
}
