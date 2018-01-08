package com.battle.servera.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Bing.Z on 2018/1/3.
 */
@FeignClient(name = "b-service")
public interface BServiceClient {

    @GetMapping("/")
    String printBService();

}
