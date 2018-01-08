package com.battle.eurekaconsumerhystrix.remote;

import org.springframework.stereotype.Component;

/**
 * Created by Bing.Z on 2017/12/12.
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{
    @Override
    public String hello(String name) {
        return "hello\t" + name + "request fail";
    }
}
