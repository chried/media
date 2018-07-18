package com.wolf.media.dto.system;

import java.io.Serializable;

/**
 * 菜单查询.
 */
public class MenuQueryForm implements Serializable {

    /**
     * 名称.
     */
    private String name;

    /**
     * 标记.
     */
    private String sign;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
