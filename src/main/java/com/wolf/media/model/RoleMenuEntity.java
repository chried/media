package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "m_system", name = "s_role_menu")
@AttributeOverride(name = "id", column = @Column(name = "r_id", length = 40))
public class RoleMenuEntity extends AbstractEntity {

    /**
     * roleId.
     */
    @Column(name = "r_role_id", length = 40)
    private String roleId;

    /**
     * menuId.
     */
    @Column(name = "r_menu_id", length = 40)
    private String menuId;

    /**
     * @备注.
     */
    @Column(name = "r_note", length = 100)
    private String note;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
