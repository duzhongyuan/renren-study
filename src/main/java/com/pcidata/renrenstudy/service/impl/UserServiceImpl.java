package com.pcidata.renrenstudy.service.impl;

import com.pcidata.renrenstudy.service.UserService;
import com.pcidata.renrenstudy.vo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: dzy
 * @Date: 2018/12/25 16:27
 * @Describe: 用户服务实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new ConcurrentHashMap<String, User>();

    @Cacheable(value = "GoodsType", key = "'username_" + "'+#user.username")
    @Override
    public User save(User user) {
        System.out.println("save()方法执行了......");
        userMap.put(user.getUsername(), user);
        return user;
    }

    @CachePut(value = "GoodsType", key = "'username_" + "'+#user.username")
    @Override
    public User update(User user) {
        System.out.println("update()方法执行了......");
        userMap.put(user.getUsername(), user);
        return user;
    }

    @CacheEvict(value = "GoodsType", key = "'username_" + "'+#username")
    @Override
    public String delete(String username) {
        System.out.println("delete()执行了......");
        userMap.remove(username);
        return "删除成功";
    }

    @Cacheable(value = "GoodsType", key = "'username_" + "'+#username")
    @Override
    public User select(String username) {
        System.out.println("select()执行了......");
        User user = userMap.get(username);
        return user;
    }
}
