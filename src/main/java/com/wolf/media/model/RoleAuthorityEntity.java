package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色权限表.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "m_system", name = "s_role_authority")
@AttributeOverride(name = "id", column = @Column(name = "r_id", length = 40))
public class RoleAuthorityEntity extends AbstractEntity {

    /**
     * roleId.
     */

    @Column(name = "r_role_id", length = 40)
    private String roleId;

    /**
     * authorityId.
     */
    @Column(name = "r_authority_id", length = 40)
    private String authorityId;

    /**
     * 备注.
     */
    @Column(name = "r_note", length = 100)
    private String note;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
