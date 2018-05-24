package com.linkstec.dao;

import com.linkstec.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常！");
        return user;
    }
}