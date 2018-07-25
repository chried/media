package com.wolf.media.controller.admin;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 页面跳转.
 */
@Controller("admin$pageController")
@RequestMapping(value = "admin/page")
public class PageController {

    /**
     * 当前菜单.
     */
    private final String currentMenu = "currentMenu";
    /**
     * 父级菜单.
     */
    private final String parentMenu = "parentMenu";

    /**
     * 首页.
     *
     * @return 首页.
     */
    @GetMapping(value = {"{page}", "{page}/{pageChild}"})
    public String index(@PathVariable(value = "page") String page, @PathVariable(value = "pageChild", required = false) String pageChild, HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();

        if (StringUtils.isNotBlank(page)) {
            sb.append("admin/" + page);
        }
        if (StringUtils.isNotBlank(pageChild)) {
            sb.append("/" + pageChild);
        }

        HttpSession session = request.getSession();

        session.setAttribute(currentMenu, "/admin/page/" + sb.substring(6, sb.length()));
        session.setAttribute(parentMenu, page);

        return sb.toString();

    }
}
