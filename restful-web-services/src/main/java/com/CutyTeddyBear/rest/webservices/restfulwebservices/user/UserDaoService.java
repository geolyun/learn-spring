package com.CutyTeddyBear.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // JPA/Hibernate > Database

    private static List<User> users = new ArrayList<>();
    // 현재는 정적 리스트가 비어 있다. 이걸 여러 사용자로 초기화한다.

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jin", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }
    //public User save(User user) {
    //public User findOne(int id) {

}
