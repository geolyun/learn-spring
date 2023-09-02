package com.CutyTeddyBear.rest.webservices.restfulwebservices.user;

import com.CutyTeddyBear.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.CutyTeddyBear.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserRepository repository;

    private PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    // 정보는 UserDaoService에서 얻어올 예정(UserDaoService는 Spring이 관리)
    //GET /users
    @GetMapping("/jpa/users")
    // 모든 사용자의 정보를 조회하는 REST API
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    // 특정 사용자의 정보를 조회하는 REST API
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);

        return user.get().getPosts();
    }


    //POST /users
    @PostMapping("/jpa/users")
    // @Valid 사용하면 바인딩이 수행될 때 객체에 정의된 유효성 검증이 자동으로 수행
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);

        // /users/4 => /users /{id},   user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // 현재 요청의 URL에 추가하고 싶은 건 path("/{id}")이다
                .buildAndExpand(savedUser.getClass()) // 이 변수는 생성된 사용자의 아이디로 바꿔주고 싶다
                .toUri(); // 그걸 URI로 변환

        // location - /users/4
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getClass())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}


// UserRepository를 연결해서 H2 데이터베이스를 사용한 코드
