package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
//@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "client")
@EnableSwagger2
public class Main {

	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		System.setProperty("spring.config.name", "client");
		 SpringApplication app = new SpringApplication(Main.class);
//	        app.setDefaultProperties(Collections
//	          .singletonMap("server.port", "2222"));
	        app.run(args);
	}
}
