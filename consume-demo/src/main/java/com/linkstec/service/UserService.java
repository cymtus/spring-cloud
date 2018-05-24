package com.linkstec.service;

import com.linkstec.dao.UserClient;
import com.linkstec.dao.UserDao;
import com.linkstec.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
//    private UserDao userDao;
    private UserClient client;

    public List<User> queryByIds(List<Long> ids) {
        List<User> list=new ArrayList<User>();
        for (Long id : ids
                ) {
            User user = client.queryById(id);
            list.add(user);
        }
        return list;
    }
}
