package com.example.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	
	public static void main(String[] args) {
	
		// 1: Launch a Spring Context
	
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
	
		// 2: Spring이 관리할 항목을 구성
		// HelloWorldConfiguration - @Configuration
		// name - @Bean
		
		// 3: Spring이 관리하는 Bean을 검색하고 있음
		System.out.println(context.getBean("name"));
		
		System.out.println(context.getBean("age"));

		System.out.println(context.getBean("person"));
		
		System.out.println(context.getBean("address"));
	}
	
}
