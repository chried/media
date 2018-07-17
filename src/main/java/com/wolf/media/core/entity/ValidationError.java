package com.wolf.media.core.entity;


import java.io.Serializable;

/**
 * 验证错误消息.
 * <pre>
 * 用于返回前端详细的错误信息.
 * </pre>
 *
 * @author gaoweibing
 */
public class ValidationError implements Serializable {

    /**
     * 属性值.
     */
    protected String field;

    /**
     * 错误消息.
     */
    protected String message;

    /**
     * 构造函数.
     *
     * @param field   属性
     * @param message 消息
     */
    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * 属性值.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * 属性值.
     *
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 错误消息.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 错误消息.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
