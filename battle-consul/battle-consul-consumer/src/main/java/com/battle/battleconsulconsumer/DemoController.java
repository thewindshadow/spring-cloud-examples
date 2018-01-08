package com.battle.battleconsulconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bing.Z on 2017/12/29.
 */

@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @GetMapping("/testConsumer")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("consul-client");
        String result = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/test";
        System.out.println("result = " + result);
        return restTemplate.getForObject(result,String.class);
    }
}
