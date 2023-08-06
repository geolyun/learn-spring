package com.example.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	
	public static void main(String[] args) {
	
		// 1: Launch a Spring Context
		try(var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			
			// 2: Spring이 관리할 항목을 구성
			// HelloWorldConfiguration - @Configuration
			// name - @Bean
			
			// 3: Spring이 관리하는 Bean을 검색하고 있음
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean(Person.class));
			
			System.out.println(context.getBean(Address.class));
			
			System.out.println(context.getBean("person5Qualifier"));
			
			// System.out.println
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
				
		}
				
	}
	
}
