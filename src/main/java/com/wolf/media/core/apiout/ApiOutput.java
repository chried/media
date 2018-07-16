package com.wolf.media.core.apiout;

import java.io.Serializable;

/**
 *
 */
public class ApiOutput<T> implements Serializable {

    /**
     * 数据.
     */
    private T data;

    /**
     * 返回信息.
     */
    private String msg;

    /**
     * 返回值.
     * <pre>
     *     100、表示成功.
     *     101、表示失败.
     * </pre>
     */
    private int code;

    /**
     * 默认构造器.
     */
    public ApiOutput() {
    }

    /**
     * 构造器.
     *
     * @param data
     */
    public ApiOutput(T data) {
        this.code = 100;
        this.data = data;
        this.msg = "操作成功";
    }

    /**
     * 返回实例.
     *
     * @return
     */
    public static ApiOutput of() {
        return new ApiOutput();
    }

    /**
     * 返回实例（有参）.
     *
     * @param data
     * @return
     */
    public static <TD> ApiOutput of(TD data) {
        return new ApiOutput(data);
    }

    /**
     * 设置操作信息.
     *
     * @param msg
     * @return
     */
    public ApiOutput msg(String msg) {
        this.code = 100;
        this.msg = msg;
        return this;
    }

    /**
     * 设置错误操作.
     *
     * @param msg
     * @return
     */
    public ApiOutput error(String msg) {
        this.code = 101;
        this.msg = msg;
        return this;
    }

    /**
     * 是否成功标记.
     *
     * @return
     */
    public boolean success() {
        return this.code == 100;
    }

    /**
     * @return data.
     */
    public T getData() {
        return data;
    }

    /**
     * 数据.
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return msg.
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 返回信息.
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return code.
     */
    public int getCode() {
        return code;
    }

    /**
     * 编号.
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }
}
