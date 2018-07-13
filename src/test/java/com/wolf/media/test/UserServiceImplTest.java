package com.wolf.media.test;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.model.UserEntity;
import com.wolf.media.service.UserService;
import com.wolf.media.utils.Convert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.wolf.media")
public class UserServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void test_保存() {
        UserEntity userEntity = new UserEntity();
        // userEntity.setId(UUID.randomUUID().toString());
        userEntity.setCode("10201201");
        userEntity.setName("chried");
        userEntity.setUsername("chried");
        userEntity.setDelete_(LocalDateTime.now());
        userEntity.setInsert_(userEntity.getDelete_());
        userEntity.setUpdate_(userEntity.getDelete_());
        ApiOutput<UserEntity> save = userService.save(userEntity);
        LOG.info("result:{}", Convert.toJson(save));
    }
}
