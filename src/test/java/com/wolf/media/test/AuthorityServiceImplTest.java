package com.wolf.media.test;


import com.wolf.media.model.AuthorityEntity;
import com.wolf.media.service.AuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.wolf.media")
public class AuthorityServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorityServiceImplTest.class);

    @Autowired
    private AuthorityService authorityService;


    @Test
    public void test_add() {
        for (int i = 0; i < 3; i++) {
            AuthorityEntity authorityEntity = new AuthorityEntity();
            authorityEntity.setCode("1010-" + (i + 1));
            authorityEntity.setName("删除按钮-" + (i + 1));
            authorityEntity.setSign("delete-" + (i + 1));
            this.authorityService.save(authorityEntity);
        }
    }
}
