package com.example.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record는 JDK 16에서 추가된 새로운 기능
// 일반적으로 Java 클래스를 만들 때는 수많은 getter, setter, method 생성자를 만들게 되는데
// 이러한 Java Bean을 만드는 번거로움을 없애기 위해 도입된 기능이 레코드 
record Person (String name, int age) { };

record Address (String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	}

	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20);
	}
	
	@Bean
	public Address address() {
		return new Address("ABC", "Cicago");
	}
}
