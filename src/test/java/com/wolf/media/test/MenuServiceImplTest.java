package com.wolf.media.test;


import com.wolf.media.dto.system.MenuQueryForm;
import com.wolf.media.model.MenuEntity;
import com.wolf.media.service.MenuService;
import com.wolf.media.utils.Convert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.wolf.media")
@ImportResource(locations = "classpath:application.properties")
public class MenuServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(MenuServiceImplTest.class);

    @Autowired
    private MenuService menuService;

    @Test
    public void test_addMenu() {

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setIcon("system");
        menuEntity.setName("系统管理");
        menuEntity.setSign("system-manage");

        this.menuService.save(menuEntity);
    }

    @Test
    public void test_query() {

        MenuQueryForm menuQueryForm = new MenuQueryForm();

        LOG.info("result:{}", Convert.toJson(menuService.query(menuQueryForm)));

    }

}
