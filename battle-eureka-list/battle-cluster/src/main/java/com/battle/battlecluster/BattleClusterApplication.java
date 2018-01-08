package com.battle.battlecluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BattleClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleClusterApplication.class, args);
	}
}
