package com.example.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record는 JDK 16에서 추가된 새로운 기능
// 일반적으로 Java 클래스를 만들 때는 수많은 getter, setter, method 생성자를 만들게 되는데
// 이러한 Java Bean을 만드는 번거로움을 없애기 위해 도입된 기능이 레코드 
record Person (String name, int age, Address address) { };

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
		return new Person("Ravi", 20, new Address("Main Street", "Utrech"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address()); // name, age
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		// name, age, address2
		return new Person(name, age, address3); // name, age
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		// name, age, address2
		return new Person(name, age, address); // name, age
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		// name, age, address2
		return new Person(name, age, address); // name, age
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("ABC", "Cicago");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Motinagar", "Hyderabed");
	}
}
