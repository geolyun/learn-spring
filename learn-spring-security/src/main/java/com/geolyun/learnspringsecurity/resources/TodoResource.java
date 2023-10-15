package com.geolyun.learnspringsecurity.resources;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    public static final List<Todo> TODOS_LIST =
            List.of(new Todo("geolyun", "Learn AWS"),
                    new Todo("geolyun", "Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/user/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/user/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {

    }
    
}

record Todo(String username, String description) {}
