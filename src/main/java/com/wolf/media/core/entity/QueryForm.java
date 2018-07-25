package com.wolf.media.core.entity;

import java.io.Serializable;

/**
 * 查询form.
 */
public class QueryForm implements Serializable {

    /**
     * 关键字.
     */
    private String q;

    /**
     * 当前页.
     */
    private int page;

    /**
     * 每页展示.
     */
    private int limit;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
