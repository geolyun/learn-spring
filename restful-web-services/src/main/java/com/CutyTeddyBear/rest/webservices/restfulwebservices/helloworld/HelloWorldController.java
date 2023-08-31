package com.CutyTeddyBear.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//REST-API
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // /hello-world
    // REST API
    @GetMapping(path = "/hello-world")
    // RequestMapping에서 method는 메서드를 path는 연결하는 URL을 구성할 수 있다.
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    // RequestMapping에서 method는 메서드를 path는 연결하는 URL을 구성할 수 있다.
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // Path Parameters
    // /users/{id}/todos/{id}
    // /hello-world/path-variable/{name}

    @GetMapping(path = "/hello-world/path-variable/{name}")
    // @PathVariable을 사용하면 요청 URI 매핑에서 템플릿 변수를 처리 하고
    // 이를 메서드 매개변수로 설정할 수 있습니다.
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World" + name);
        // return new HelloWorldBean(String.format("Hello World, %s", name)); -> String.format 사용하는 방법
    }

    @GetMapping(path = "/hello-world-internationalized")
    // RequestMapping에서 method는 메서드를 path는 연결하는 URL을 구성할 수 있다.
    public String helloWorldInternationalized() {

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

        // return "Hello World V2";
    }
}
