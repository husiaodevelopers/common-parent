package com.common.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Jamie
 */
@Component
public class RedisUtils {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtils.redisTemplate = redisTemplate;
    }

    public static RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 寫入緩存
     *
     * @param key   缓存键
     * @param value 缓存值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 寫入緩存並設置過期時間
     *
     * @param key     缓存键
     * @param value   缓存值
     * @param timeout 過期時間(秒)
     * @return true成功 false失败
     */
    public boolean set(String key, Object value, long timeout) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 獲取缓存值
     *
     * @param key 缓存键
     * @return 缓存值
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     *
     * @param key 缓存键
     * @return true成功 false失败
     */
    public boolean delete(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
