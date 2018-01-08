package com.battle.eurekasencond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BattleEurekaSencondApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleEurekaSencondApplication.class, args);
	}
}
