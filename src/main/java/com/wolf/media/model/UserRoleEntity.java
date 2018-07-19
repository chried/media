package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户角色表.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "m_system", name = "s_user_role")
@AttributeOverride(name = "id", column = @Column(name = "u_id", length = 40))
public class UserRoleEntity extends AbstractEntity {

    /**
     * userId.
     */
    @Column(name = "u_user_id", length = 40)
    private String userId;

    /**
     * roleId.
     */
    @Column(name = "u_role_id", length = 40)
    private String roleId;

    /**
     * 备注.
     */
    @Column(name = "u_note", length = 40)
    private String note;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
