package com.linkstec.service;

import com.linkstec.dao.UserMapper;
import com.linkstec.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        /*try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.userMapper.selectByPrimaryKey(id);
    }
}
