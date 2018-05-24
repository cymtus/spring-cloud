package com.linkstec.controller;

import com.linkstec.pojo.User;
import com.linkstec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> queryByIds(@RequestParam("ids") List<Long> ids){
        return userService.queryByIds(ids);
    }
}
