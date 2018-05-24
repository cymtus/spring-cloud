package com.linkstec.dao;


import com.linkstec.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao{

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryById(Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
//        ServiceInstance in = instances.get(0);
//        String url="http://"+in.getHost()+":"+in.getPort()+"/user/"+id;
        // 地址直接写服务名称即可
        String url="http://user-service/user/"+id;
        long time1 = System.currentTimeMillis();
        User user = this.restTemplate.getForObject(url, User.class);
        long time2 =System.currentTimeMillis();
        System.out.println(time2-time1);
        return user;
    }

    public User queryUserByIdFallback(Long id){
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        return user;
    }
}
