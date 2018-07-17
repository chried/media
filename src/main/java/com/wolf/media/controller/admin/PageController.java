package com.wolf.media.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转.
 */
@Controller("admin$pageController")
@RequestMapping(value = "page")
public class PageController {

    /**
     * 首页.
     *
     * @return 首页.
     */
    @RequestMapping(value = "index")
    public String index() {
        return "admin/index";
    }
}
