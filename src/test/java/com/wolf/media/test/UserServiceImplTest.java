package com.wolf.media.test;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.model.RoleEntity;
import com.wolf.media.model.UserEntity;
import com.wolf.media.service.RoleService;
import com.wolf.media.service.UserService;
import com.wolf.media.utils.Convert;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.wolf.media")
public class UserServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    public void test_保存() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCode("10201201");
        userEntity.setName("chried");
        userEntity.setUsername("chried");
        userEntity.setPassword(DigestUtils.md5Hex("123456"));
        ApiOutput<UserEntity> save = userService.save(userEntity);
        LOG.info("result:{}", Convert.toJson(save));
    }

    @Test
    @Transactional
    public void test_授予角色() {
        List<RoleEntity> roleEntities = this.roleService.queryAll();
        UserEntity userEntity = this.userService.get_("c76607f4-e2af-4752-8741-a1059fdccdaf");
        for (RoleEntity roleEntity : roleEntities) {
            this.roleService.save(roleEntity);
        }
    }

    @Test
    @Transactional
    public void test_查询用户() {
        UserEntity userEntity = this.userService.get_("0b2e82bf-3b0c-4e3e-869f-110d3a53a835");
        LOG.info("userEntity:{}", userEntity.getName());
    }

    @Test
    public void test_remove() {
        ApiOutput<Integer> remove = this.userService.remove("3cb1576a-38fb-443f-908f-453629fff03a");
        LOG.info("remove:{}", Convert.toJson(remove));
    }

    @Test
    public void test_removeBatch() {
        ApiOutput<Integer> remove = this.userService.removeBatch(Arrays.asList("3cb1576a-38fb-443f-908f-453629fff03a"));
        LOG.info("remove:{}", Convert.toJson(remove));
    }

    @Test
    public void test_delete() {
        ApiOutput<Integer> remove = this.userService.delete("3cb1576a-38fb-443f-908f-453629fff03a");
        LOG.info("remove:{}", Convert.toJson(remove));
    }

    @Test
    public void test_deleteBatch() {
        ApiOutput<Integer> remove = this.userService.deleteBatch(Arrays.asList("e083b326-a0a1-4794-8ca6-abfe20f8da4d"));
        LOG.info("remove:{}", Convert.toJson(remove));
    }

}
