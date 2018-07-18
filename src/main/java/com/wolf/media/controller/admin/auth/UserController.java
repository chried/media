package com.wolf.media.controller.admin.auth;

import com.wolf.media.cache.TokenCache;
import com.wolf.media.core.controller.AbstractController;
import com.wolf.media.core.entity.Parameter;
import com.wolf.media.core.service.AbstractService;
import com.wolf.media.dao.TokenCacheRepository;
import com.wolf.media.model.UserEntity;
import com.wolf.media.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chried
 */
@RestController("admin$auth$user")
@RequestMapping(value = "user")
public class UserController extends AbstractController<UserEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TokenCacheRepository tokenCacheRepository;

    /**
     * 获取service.
     *
     * @return
     */
    @Override
    public AbstractService<UserEntity> getService() {
        return userService;
    }

    /**
     * 退出.
     */
    @RequestMapping(value = "logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        TokenCache tokenCache = this.getToken();

        //清除当前redis-token.
        tokenCacheRepository.delete(tokenCache);

        HttpSession session = request.getSession();
        //移除菜单.
        session.removeAttribute(Parameter.MENU);
        //移除token.
        session.removeAttribute(Parameter.TOKEN);

        try {
            response.sendRedirect(request.getContextPath() + "/page/login");
        } catch (IOException e) {
            LOG.error("用户'{}'退出出现异常,{}", tokenCache.getName(), e.getMessage());
        }
    }
}
