package com.wolf.media.model;

import com.wolf.media.core.entity.AbstractEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;


/**
 * 角色表.
 *
 * @author chried
 */
@Entity
@Table(schema = "m_system", name = "s_role")
@AttributeOverride(name = "id", column = @Column(name = "r_id", updatable = false, length = 40))
public class RoleEntity extends AbstractEntity {

    /**
     * 名称.
     */
    @Column(name = "r_name", length = 20)
    private String name;

    /**
     * 标记.
     */
    @Column(name = "r_sign", length = 20)
    private String sign;

    /**
     * 编号.
     */
    @Column(name = "r_code", length = 20)
    private String code;

    /**
     * 排序.
     */
    @Column(name = "r_sort", length = 3)
    private int sort;

    /**
     * 备注.
     */
    @Column(name = "r_note", length = 200)
    private String note;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "userId", updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity userEntity;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "role_authority", schema = "m_system",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "r_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "a_id")})
    private List<AuthorityEntity> authoritys;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<AuthorityEntity> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(List<AuthorityEntity> authoritys) {
        this.authoritys = authoritys;
    }
}
