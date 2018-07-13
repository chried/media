package com.wolf.media.core.entity;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


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
     * 扩展属性.
     */
    @Embedded
    private Extend extend;

    public AbstractEntity() {
        this.extend = new Extend();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }
}
