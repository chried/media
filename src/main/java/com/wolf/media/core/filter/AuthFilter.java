package com.wolf.media.core.filter;

import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.Parameter;
import com.wolf.media.utils.Convert;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author gaoweibing
 */
public class AuthFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        LOG.info("登录过滤器,初始化参数,{}", Convert.toJson(filterConfig));

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = this.getToken(request);

        if (StringUtils.isBlank(token)) {
            response.sendError(999);
            ApiOutput<String> apiOutput = new ApiOutput<>();
            apiOutput.error("用户未登录");
            PrintWriter writer = response.getWriter();
            writer.write(Convert.toJson(apiOutput));
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

        LOG.info("登录过滤器销毁.");

    }

    /**
     * 获取token.
     *
     * @param request 当前请求.
     * @return token.
     */
    private String getToken(HttpServletRequest request) {

        return request.getParameter(Parameter.TOKEN) == null ? request.getHeader(Parameter.TOKEN) : request.getParameter(Parameter.TOKEN);

    }
}
