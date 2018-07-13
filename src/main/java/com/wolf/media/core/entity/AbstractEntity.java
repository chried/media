package com.wolf.media.core.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
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
    private String id;

    /**
     * 定义状态.
     */
    @Column(name = "z_status")
    private String status_;

    /**
     * 定义创建时间.
     */
    @Column(name = "z_insert", updatable = false)
    private LocalDateTime insert_;


    /**
     * 定义更新时间.
     */
    @Column(name = "z_update")
    private LocalDateTime update_;

    /**
     * 定义删除时间.
     */
    @Column(name = "z_delete")
    private LocalDateTime delete_;

    /**
     * 数据版本.
     * <pre>
     *     从1开始.
     * </pre>
     */
    @Column(name = "z_version")
    private int version;


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

    public LocalDateTime getInsert_() {
        return insert_;
    }

    public void setInsert_(LocalDateTime insert_) {
        this.insert_ = insert_;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
