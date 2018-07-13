/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf.media.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Map;

/**
 * JSON(或XML)序列化、反序列化转换工具.
 *
 * @author Handsome
 * @version 1.0
 */
public final class Convert {

    private static final Logger LOG = LoggerFactory.getLogger(Convert.class);

    /**
     * 隐藏构造函数.
     */
    private Convert() {
    }

    /**
     * 将对象转换成XML.
     *
     * @param object 对象
     * @return xml字符串
     */
    public static String toXml(Object object) {

        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            Writer writer = new StringWriter();

            marshaller.marshal(object, writer);

            return writer.toString();
        } catch (JAXBException ex) {
            LOG.error("不成创建JAXBContext", ex);
        }

        return "";
    }

    /**
     * 从XML反序列化对象.
     *
     * @param xml XML字符串(UTF-8)
     * @param clazz 目标类
     * @return 对象.
     */
    public static Object fromXml(String xml, Class clazz) {

        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Reader reader = new StringReader(xml);

            return unmarshaller.unmarshal(reader);

        } catch (JAXBException ex) {
            LOG.error("不成创建JAXBContext", ex);
        }

        return null;
    }

    /**
     * 从xml中恢复.
     *
     * @param xml xml字符串.
     * @param classesToBeBound 类.
     * @param properties 属性.
     * @return 对象.
     */
    public static Object fromXml(String xml, Class[] classesToBeBound, Map<String, ?> properties) {

        try {
            JAXBContext context = JAXBContext.newInstance(classesToBeBound, properties);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Reader reader = new StringReader(xml);

            return unmarshaller.unmarshal(reader);

        } catch (JAXBException ex) {
            LOG.error("不成创建JAXBContext", ex);
        }

        return null;
    }

    /**
     * 从xml转成对象.
     *
     * @param xml xml字符串.
     * @param contextPath 路径.
     * @return 对象.
     */
    public static Object fromXml(String xml, String contextPath) {

        try {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Reader reader = new StringReader(xml);

            return unmarshaller.unmarshal(reader);

        } catch (JAXBException ex) {
            LOG.error("不成创建JAXBContext", ex);
        }

        return null;
    }

    /**
     * 全局Gson构建器.
     */
    private static GsonBuilder builder;

    /**
     * 从全局Gson构建器创建Gson对象.
     *
     * @return Gson对象
     */
    public static Gson getGson() {

        // 检查全局builder是否为空
        if (builder == null) {

            builder = new GsonBuilder();

            // 设置格式
            builder.setDateFormat(DateFormat.LONG);
            builder.setPrettyPrinting();

        }

        return builder.create();
    }

    /**
     * 对象转字符串.
     *
     * @param object 对象.
     * @return json字符串.
     */
    public static String toJson(Object object) {
        return getGson().toJson(object);
    }

    /**
     * 从json字符串转成对象.
     *
     * @param json json字符串.
     * @param clazz 类.
     * @param <T> 枚举值.
     * @return 对象.
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

    /**
     * 反序列化多级泛型.
     *
     * @param <T> 泛型类
     * @param json JSON字符串
     * @param type 泛型类的引用 new TypeToken&lt;Foo&lt;List&lt;T&gt;&gt;&gt;()
     * {}.get()
     * @return 对象数据
     */
    public static <T> T fromJson(String json, Type type) {
        return getGson().fromJson(json, type);
    }
}
