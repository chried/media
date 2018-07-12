package com.wolf.media.core.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 定义顶级基类.
 *
 * @author chried
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

    /**
     * 主键.
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 定义状态.
     */
    @Column(name = "m_status")
    private String status_;

    /**
     * 定义创建时间.
     */
    @Column(name = "m_insert")
    private LocalDateTime inert_;


    /**
     * 定义更新时间.
     */
    @Column(name = "m_update")
    private LocalDateTime update_;

    /**
     * 定义删除时间.
     */
    @Column(name = "m_delete")
    private LocalDateTime delete_;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus_() {
        return status_;
    }

    public void setStatus_(String status_) {
        this.status_ = status_;
    }

    public LocalDateTime getInert_() {
        return inert_;
    }

    public void setInert_(LocalDateTime inert_) {
        this.inert_ = inert_;
    }

    public LocalDateTime getUpdate_() {
        return update_;
    }

    public void setUpdate_(LocalDateTime update_) {
        this.update_ = update_;
    }

    public LocalDateTime getDelete_() {
        return delete_;
    }

    public void setDelete_(LocalDateTime delete_) {
        this.delete_ = delete_;
    }
}
