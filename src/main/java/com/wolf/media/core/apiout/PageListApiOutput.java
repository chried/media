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
     * @param pageNo     当前页.
     * @param pageSize   每页显示.
     * @param totalPage  总页数.
     * @param totalCount 总数.
     */
    public PageListApiOutput(int pageNo, int pageSize, int totalPage, long totalCount, List<T> data) {

        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        setData(data);

    }

    /**
     * 总数.
     */
    private long totalCount;

    /**
     * 总页数.
     */
    private int totalPage;

    /**
     * 每页展示.
     */
    private int pageSize;

    /**
     * 当前页.
     */
    private int pageNo;

    /**
     * 获取分组.
     *
     * @param page
     * @param <E>
     * @return
     */
    public static <E> PageListApiOutput of(Page<E> page) {

        return new PageListApiOutput(page.getPageable().getPageNumber(), page.getPageable().getPageSize(), page.getTotalPages(), page.getTotalElements(), page.getContent());

    }

    /**
     * @return totalCount.
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * 总数.
     *
     * @param totalCount
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return totalPage.
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * totalPage.
     *
     * @param totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * @return pageSize.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * pageSize.
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return pageNo.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * pageNo.
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
