package com.battle.eurekaconsumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bing.Z on 2017/12/12.
 */
@FeignClient(name = "battle-eureka-producer")
public interface HelloRemote {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name);
}
