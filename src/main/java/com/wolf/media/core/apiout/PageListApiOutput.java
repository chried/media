package com.wolf.media.core.apiout;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 定义分组.
 */
public class PageListApiOutput<T> extends ApiOutput<List<T>> {

    /**
     * 构造器.
     *
     * @param data
     */
    public PageListApiOutput(List<T> data) {
        super(data);
    }

    /**
     * 构造器
     *
     * @param totalCount 总数.
     */
    public PageListApiOutput(long totalCount, List<T> data) {

        this.count = totalCount;
        setData(data);

    }

    /**
     * 总数.
     */
    private long count;

    /**
     * 获取分组.
     *
     * @param page
     * @param <E>
     * @return
     */
    public static <E> PageListApiOutput of(Page<E> page) {

        return new PageListApiOutput(page.getTotalElements(), page.getContent());

    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
