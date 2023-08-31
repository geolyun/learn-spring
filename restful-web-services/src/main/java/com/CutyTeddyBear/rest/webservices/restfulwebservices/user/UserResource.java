package com.CutyTeddyBear.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // 정보는 UserDaoService에서 얻어올 예정(UserDaoService는 Spring이 관리)
    //GET /users
    @GetMapping("/users")
    // 모든 사용자의 정보를 조회하는 REST API
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    // 특정 사용자의 정보를 조회하는 REST API
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    //POST /users
    @PostMapping("/users")
    // @Valid 사용하면 바인딩이 수행될 때 객체에 정의된 유효성 검증이 자동으로 수행
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        // /users/4 => /users /{id},   user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // 현재 요청의 URL에 추가하고 싶은 건 path("/{id}")이다
                .buildAndExpand(savedUser.getClass()) // 이 변수는 생성된 사용자의 아이디로 바꿔주고 싶다
                .toUri(); // 그걸 URI로 변환

        // location - /users/4
        return ResponseEntity.created(location).build();
    }

}
