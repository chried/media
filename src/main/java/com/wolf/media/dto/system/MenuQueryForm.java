package com.wolf.media.dto.system;

import com.wolf.media.core.entity.QueryForm;

/**
 * 菜单查询.
 */
public class MenuQueryForm extends QueryForm {

    /**
     * 名称.
     */
    private String name;

    /**
     * 标记.
     */
    private String sign;

    /**
     * 父节点.
     */
    private String parentId;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
