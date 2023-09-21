package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	//http://localhost:3000/ to 8080
	//Cross Origin Requests
	//Allow all requests only from http://localhost:3000/

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // addMapping()은 특정한 패턴에 대해 크로스 오리진 리퀘스트 처리를 가능하게 해줌
						.allowedMethods("*") // 어떤 종류의 메서드가 허용되는지 알려줌
						.allowedOrigins("http://localhost:3000"); // 요청이 어디서 오고 있는지 알려줌
			}
		};
	}
}
