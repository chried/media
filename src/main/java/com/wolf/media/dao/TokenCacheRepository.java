package com.wolf.media.dao;

import com.wolf.media.cache.TokenCache;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaoweibing
 */
@Repository
public interface TokenCacheRepository extends KeyValueRepository<TokenCache, String> {
}
