package com.wolf.media.service;

import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.MenuRepository;
import com.wolf.media.dao.UserRepository;
import com.wolf.media.model.MenuEntity;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.model.UserEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoweibing
 */
@Service
public class MenuServiceImpl extends AbstractServiceImpl<MenuEntity> implements MenuService {

    private static final Logger LOG = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取Repository.
     *
     * @return
     */
    @Override
    public AbstractRepository<MenuEntity> getRepository() {
        return menuRepository;
    }

    /**
     * 获取class.
     */
    @Override
    public Class<MenuEntity> getClazz() {
        return MenuEntity.class;
    }

    /**
     * 获取当前用户拥有的菜单.
     *
     * @param userId 用户id.
     * @return 菜单列表.
     */
    @Override
    public List<MenuEntity> getCurrentMenu_(String userId) {

        UserEntity userEntity = userRepository.getOne(userId);

        if (userEntity == null) {

            LOG.error("获取菜单错误，用户不存在");
            throw new ValidationException("用户不存在");

        }

        List<MenuEntity> menuEntities = new ArrayList<>();

        if (CollectionUtils.isEmpty(userEntity.getRoles())) {

            LOG.error("获取菜单错误，用户没有任何角色");
            throw new ValidationException("用户没有任何角色.");

        }

        for (RoleEntity role : userEntity.getRoles()) {

            menuEntities.addAll(role.getMenus());

        }

        return menuEntities;
    }
}