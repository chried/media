package com.wolf.media.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wolf.media.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 权限表.
 *
 * @author chried
 */
@Entity
@Table(schema = "m_system", name = "s_authority")
@AttributeOverride(name = "id", column = @Column(name = "a_id", updatable = false, length = 40))
public class AuthorityEntity extends AbstractEntity {

    /**
     * 名称.
     */
    @Column(name = "a_name", length = 20)
    private String name;

    /**
     * 标记.
     */
    @Column(name = "a_sign", length = 20)
    private String sign;

    /**
     * 编号.
     */
    @Column(name = "a_code", length = 20)
    private String code;

    /**
     * 排序.
     */
    @Column(name = "a_sort", length = 3)
    private int sort;

    /**
     * 备注.
     */
    @Column(name = "a_note", length = 200)
    private String note;


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
}
