package com.wolf.media.service;

import com.wolf.media.core.apiout.PageListApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.entity.EntityParameter;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.MenuRepository;
import com.wolf.media.dao.RoleMenuRepository;
import com.wolf.media.dao.UserRepository;
import com.wolf.media.dao.UserRoleRepository;
import com.wolf.media.dto.system.MenuQueryForm;
import com.wolf.media.model.*;
import com.wolf.media.vo.system.MenuAdminResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gaoweibing
 */
@Service
public class MenuServiceImpl extends AbstractServiceImpl<MenuEntity> implements MenuService {

    private static final Logger LOG = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RoleMenuRepository roleMenuRepository;

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

        //获取用户角色关系图.
        List<RoleMenuEntity> roleMenuEntities = this.roleMenuRepository.queryByUserId(userId, EntityParameter.ACTIVE_);

        if (CollectionUtils.isEmpty(roleMenuEntities)) {

            LOG.error("获取菜单错误，没有关联菜单");
            throw new ValidationException("没有关联菜单.");
        }

        //获取菜单ids.
        List<String> menuIds = roleMenuEntities.stream().map(r -> r.getMenuId()).collect(Collectors.toList());

        return this.menuRepository.findAllById(menuIds);

    }

    /**
     * 获取用户菜单.
     *
     * @param userId 用户id.
     * @return 菜单列表.
     */
    @Override
    public List<MenuAdminResult> getAdminMenus_(String userId) {

        /**
         * 获取当前用户所有菜单.
         */
        List<MenuEntity> currentMenus = this.getCurrentMenu_(userId);

        if (CollectionUtils.isEmpty(currentMenus)) {
            LOG.error("获取菜单错误，没有关联菜单");
            throw new ValidationException("没有关联菜单.");
        }

        /**
         * 按照父id,重新组装menu.
         */
        Map<String, List<MenuEntity>> parentMenuMap = currentMenus.stream().filter(m -> StringUtils.isNotBlank(m.getParentId())).collect(Collectors.groupingBy(MenuEntity::getParentId));

        //菜单返回结果.
        List<MenuAdminResult> results = new ArrayList<>();

        for (MenuEntity menuEntity : currentMenus) {
            if (StringUtils.equalsIgnoreCase("-", menuEntity.getParentId())) {

                //找出当前父节点子菜单.
                List<MenuEntity> childMenus = parentMenuMap.get(menuEntity.getId());

                MenuAdminResult menuAdminResult = new MenuAdminResult();

                menuAdminResult.setMenu(menuEntity);
                menuAdminResult.setMenus(childMenus);

                results.add(menuAdminResult);
            }

        }

        return results;
    }

    /**
     * 查询.
     *
     * @param form
     * @return
     */
    @Override
    public PageListApiOutput<MenuEntity> query(MenuQueryForm form) {


        LOG.info("菜单查询.");


        Page<MenuEntity> page = this.menuRepository.query(
                StringUtils.isBlank(form.getParentId()) ? "-" : form.getParentId(),
                StringUtils.isBlank(form.getName()) ? "%" : form.getName(),
                StringUtils.isBlank(form.getSign()) ? "%" : form.getSign(),
                EntityParameter.ACTIVE_, PageRequest.of(form.getPage() - 1, form.getLimit())
        );

        return PageListApiOutput.of(page);
    }
}
