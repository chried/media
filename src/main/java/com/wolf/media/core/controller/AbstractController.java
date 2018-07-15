package com.wolf.media.core.controller;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.AbstractEntity;
import com.wolf.media.core.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义controller顶级.
 *
 * @author chried
 */
public abstract class AbstractController<T extends AbstractEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);

    /**
     * 获取service.
     *
     * @return
     */
    public abstract AbstractService<T> getService();

    /**
     * save操作.
     *
     * @param t
     * @return
     */
    @PostMapping(value = "save")
    public ApiOutput<T> save(T t) {

        LOG.info("开始save操作.");

        return this.getService().save(t);

    }

    /**
     * get操作.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "get")
    public ApiOutput<T> get(@RequestParam(value = "id") String id) {

        LOG.info("get操作.");

        return this.getService().get(id);

    }

    /**
     * getOfEdit操作.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "getOfEdit")
    public ApiOutput<T> getOfEdit(@RequestParam(value = "id", required = false) String id) {

        LOG.info("getOfEdit操作.");

        return this.getOfEdit(id);
    }


}
