package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 菜单.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "m_system", name = "s_menu")
@AttributeOverride(name = "id", column = @Column(name = "m_id", length = 40))
public class MenuEntity extends AbstractEntity {

    /**
     * 上级节点.
     */
    @Column(name = "m_parentId", length = 40)
    private String parentId;

    /**
     * 名称.
     */
    @Column(name = "m_name", length = 20)
    private String name;

    /**
     * 标识.
     */
    @Column(name = "m_sign", length = 30)
    private String sign;

    /**
     * 图标.
     */
    @Column(name = "m_icon", length = 20)
    private String icon;

    /**
     * 连接.
     */
    @Column(name = "m_url", length = 100)
    private String url;

    /**
     * 排序.
     */
    @Column(name = "m_sort", length = 3)
    private int sort;

    /**
     * 所属角色.
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menus")
    private List<RoleEntity> roles;


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
