package com.linkstec.dao;

import com.linkstec.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "user-service",fallback = UserFeignClientFallback.class,path = "user")
//@RequestMapping("user")
public interface UserClient {

    @GetMapping("/{id}")
    User queryById(@PathVariable("id") Long id);
}
