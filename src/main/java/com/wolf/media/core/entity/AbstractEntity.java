package com.wolf.media.core.entity;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
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
     * 是否验证.
     */
    @Transient
    private boolean valid;

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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }
}
