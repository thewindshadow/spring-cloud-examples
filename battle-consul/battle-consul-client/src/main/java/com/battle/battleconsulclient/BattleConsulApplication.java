package com.battle.battleconsulclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class BattleConsulApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BattleConsulApplication.class, args);
		new SpringApplicationBuilder(BattleConsulApplication.class).web(true).run(args);
	}

}
