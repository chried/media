package com.wolf.media.core.resolver;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.ValidationError;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常处理.
 *
 * @author tangfeifei
 */
@RestControllerAdvice
public class ExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionResolver.class);


    /**
     * 捕获空指针异常.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ApiOutput<String> processNullPointerException(NullPointerException ex) {

        LOG.warn("空指针异常", ex);

        return ApiOutput.of(ExceptionUtils.getStackTrace(ex))
                .error("空指针异常!");
    }

    /**
     * 自动注入的绑定错误.
     *
     * @param ex 异常
     * @return 带有详细信息的错误提示
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<List<ValidationError>> processBindException(BindException ex) {

        LOG.debug("数据绑定错误", ex);

        List<ValidationError> errors = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        ex.getFieldErrors().forEach((fe) -> {
            errors.add(new ValidationError(fe.getField(), fe.getDefaultMessage()));
            sb.append(fe.getDefaultMessage());
            sb.append(" ");
        });

        return ApiOutput.of(errors)
                .error(sb.toString());
    }

    /**
     * 传入的参数类型不匹配.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {

        LOG.debug("传入的参数类型不匹配", ex);

        return ApiOutput.of()
                .error("传入的参数类型不匹配!");
    }

    /**
     * 反序列化失败.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        LOG.debug("反序列化失败", ex);

        return ApiOutput.of()
                .error("反序列化失败!");
    }

    /**
     * 类型转换失败.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processInvalidFormatException(InvalidFormatException ex) {

        LOG.warn("类型转换失败", ex);

        return ApiOutput.of()
                .error("类型转换失败!");
    }

    /**
     * 数据格式不合法的验证错误.
     *
     * @param ex 异常
     * @return 带有详细信息的错误提示
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<List<ValidationError>> processConstraintViolationException(ConstraintViolationException ex) {

        LOG.debug("数据格式校验未通过", ex);

        List<ValidationError> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach((cv) -> {
            errors.add(new ValidationError(
                    cv.getPropertyPath().toString(),
                    cv.getMessage()));
        });

        return ApiOutput.of(errors)
                .error(ex.getLocalizedMessage());
    }

    /**
     * 全局拦截验证错误.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processValidationException(ValidationException ex) {

        LOG.debug(ex.getMessage(), ex);

        return ApiOutput.of()
                .error(ex.getMessage());
    }

    /**
     * 输入参数不匹配.
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processIllegalArgumentException(IllegalArgumentException ex) {

        LOG.debug("输入参数不匹配", ex);

        return ApiOutput.of()
                .error("输入参数不匹配!");
    }

    /**
     * 找不到页面..
     *
     * @param ex 异常
     * @return 消息
     */
    @ExceptionHandler(TemplateInputException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ApiOutput<String> processTemplateInputException(TemplateInputException ex) {

        LOG.debug("找不到页面.", ex);

        return ApiOutput.of()
                .error("找不到页面!");
    }

}
