package com.battle.servera;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@EnableDiscoveryClient
@EnableHystrix  //@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class ServerAApplication {

	@Bean
	public Docket docket(){
		ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2).select();
		apiSelectorBuilder.apis(withClassAnnotation(Api.class));
		return apiSelectorBuilder
				.build()
				.pathMapping("/")
				.useDefaultResponseMessages(false)
				.apiInfo(new ApiInfo("Service A API Doc", "Service A API Doc", "1.0", "https://github.com/",
						new Contact("Michael", "https://github.com", "thewindshadow@163.com"), null, null))
				.forCodeGeneration(true);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerAApplication.class, args);
	}
}
