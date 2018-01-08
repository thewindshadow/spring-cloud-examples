package com.battle.servera.controller;

import com.battle.servera.hystrix.HystrixWrappedBServiceClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bing.Z on 2018/1/3.
 */

@RefreshScope
@RestController
@Api
public class AServiceController {

    @Value("${name:unknown}")
    private String name;
    @Autowired
    private HystrixWrappedBServiceClient serviceBClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String test(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>name:" + name + "<br/>" +  serviceBClient.printBService();
    }
}
