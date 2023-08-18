package com.CutyTeddyBear.springboot.learnjpaandhibernate.course.jpa;

import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    // @Autowired가 스프링 빈을 주입한다면, @PersistenceContext는 JPA 스펙에서 제공하는 기능인데, 영속성 컨텍스트를 주입하는 표준 어노테이션이다.
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}

