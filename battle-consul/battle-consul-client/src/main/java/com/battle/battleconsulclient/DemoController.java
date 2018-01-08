package com.battle.battleconsulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bing.Z on 2017/12/29.
 */

@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public String test(){
        List<String> services = discoveryClient.getServices();
        String str = "services = " + services;
        System.out.println(str);
        return str;
    }
}
