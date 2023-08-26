package com.CutyTeddyBear.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String name;
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

}

// 사용자의 상세 정보를 저장하고, 검색하고, 특정 사용자를 삭제하는 등 특정 사용자에 대해 다양한 작업을 하고자 한다.
// 데이터베이스를 관리하고, 데이터베이스에 저장된 데이터를 가지고 작업하려면 DAO(data access object) 객체를 만들어야 한다.
