package com.battle.servera.hystrix;

import com.battle.servera.feign.BServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bing.Z on 2018/1/3.
 */
@Service
public class HystrixWrappedBServiceClient implements BServiceClient{

    @Autowired
    private BServiceClient bServiceClient;


    @HystrixCommand(groupKey = "helloGroup",fallbackMethod = "fallBackCall")
    @Override
    public String printBService() {
        return bServiceClient.printBService();
    }

    public String fallBackCall(){
        return "FAILED B SERVICE CALL! - FALLING BACK ";
    }
}
