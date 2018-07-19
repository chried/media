package com.wolf.media.test;


import com.wolf.media.model.AuthorityEntity;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.service.AuthorityService;
import com.wolf.media.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.wolf.media")
public class RoleServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImplTest.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthorityService authorityService;

    @Test
    public void test_add() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("管理员");
        roleEntity.setCode("10101");
        roleEntity.setSign("manage");
        this.roleService.save(roleEntity);
    }

    @Test
    @Transactional
    public void test_角色设置权限() {
        List<AuthorityEntity> authorityEntities = authorityService.queryAll();
        RoleEntity roleEntity = this.roleService.get_("3cf831eb-0fd6-465e-80ea-1cff6bab8ce0");
        this.roleService.save(roleEntity);
    }
}
