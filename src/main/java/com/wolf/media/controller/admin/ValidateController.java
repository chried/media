package com.wolf.media.controller.admin;


import com.wolf.media.cache.TokenCache;
import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.entity.Parameter;
import com.wolf.media.dto.LoginForm;
import com.wolf.media.service.MenuService;
import com.wolf.media.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gaoweibing
 */
@RestController("admin$validate")
@RequestMapping(value = "valid")
public class ValidateController {

    private static final Logger LOG = LoggerFactory.getLogger(ValidateController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "login")
    public ApiOutput<String> login(@RequestBody LoginForm form, HttpServletRequest request, BindingResult result) {

        LOG.info("用户登录,{}", form.getUsername());

        //验证登录.
        ApiOutput<TokenCache> tokenCacheApiOutput = userService.loginByName(form);

        //成功之后存menu、token到session.
        HttpSession session = request.getSession();

        session.setAttribute(Parameter.TOKEN, tokenCacheApiOutput.getData());
        session.setAttribute(Parameter.MENU, menuService.getCurrentMenu_(tokenCacheApiOutput.getData().getUserId()));

        return ApiOutput.of("登陆成功");
    }

}
