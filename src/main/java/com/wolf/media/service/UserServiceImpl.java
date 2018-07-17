package com.wolf.media.service;


import com.wolf.media.cache.TokenCache;
import com.wolf.media.core.apiout.ApiOutput;
import com.wolf.media.core.dao.AbstractRepository;
import com.wolf.media.core.entity.EntityParameter;
import com.wolf.media.core.service.AbstractServiceImpl;
import com.wolf.media.dao.TokenCacheRepository;
import com.wolf.media.dao.UserRepository;
import com.wolf.media.dto.LoginForm;
import com.wolf.media.model.UserEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Collection;
import java.util.UUID;

/**
 * @author chried
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity> implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenCacheRepository tokenCacheRepository;

    /**
     * 获取Repository.
     *
     * @return
     */
    @Override
    public AbstractRepository<UserEntity> getRepository() {
        return userRepository;
    }

    /**
     * 获取class.
     */
    @Override
    public Class<UserEntity> getClazz() {
        return UserEntity.class;
    }

    /**
     * 授权.
     *
     * @return 成功标记.
     */
    @Override
    @Transactional
    public ApiOutput<String> authorizeRole(Collection<String> roleIds) {


        return ApiOutput.of("操作成功");
    }

    /**
     * 用户登录.
     *
     * @param form 登录模型.
     * @return token信息.
     */
    @Override
    public ApiOutput<TokenCache> loginByName(LoginForm form) {

        UserEntity userEntity = userRepository.findByUsername(form.getUsername());

        if (userEntity == null) {
            throw new ValidationException("用户未注册");
        }

        if (!StringUtils.equalsIgnoreCase(userEntity.getPassword(), DigestUtils.md5Hex(form.getPassword()))) {
            throw new ValidationException("用户名或密码错误");
        }

        if (!StringUtils.equalsIgnoreCase(userEntity.getExtend().getStatus_(), EntityParameter.ACTIVE_)) {
            throw new ValidationException("账号异常，请联系管理员！");
        }

        //创建token.
        TokenCache tokenCache = this.createTokenCache(userEntity);

        this.tokenCacheRepository.save(tokenCache);

        return ApiOutput.of(tokenCache);
    }

    /**
     * 根据用户创建token缓存.
     *
     * @param entity 用户实体.
     * @return tokenCache.
     */
    private TokenCache createTokenCache(UserEntity entity) {

        TokenCache tokenCache = new TokenCache();
        tokenCache.setName(entity.getName());
        tokenCache.setUserId(entity.getId());
        tokenCache.setUsername(entity.getUsername());
        tokenCache.setId(UUID.randomUUID().toString());

        return tokenCache;
    }
}
