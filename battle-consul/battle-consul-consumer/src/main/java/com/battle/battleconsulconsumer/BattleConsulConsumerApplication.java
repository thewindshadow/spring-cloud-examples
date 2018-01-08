package com.battle.battleconsulconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class BattleConsulConsumerApplication {

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BattleConsulConsumerApplication.class, args);
	}
}
