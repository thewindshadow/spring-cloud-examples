package com.battle.eurekaconsumerhystrix.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bing.Z on 2017/12/12.
 */
@FeignClient(name = "battle-eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name);
}
