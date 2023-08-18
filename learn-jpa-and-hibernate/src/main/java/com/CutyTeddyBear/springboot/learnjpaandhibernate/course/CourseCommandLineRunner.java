package com.CutyTeddyBear.springboot.learnjpaandhibernate.course;

import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.Course;
import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Now!", "geolyun"));
        repository.save(new Course(2, "Learn Azure Now!", "geolyun"));
        repository.save(new Course(3, "Learn JS Now!", "geolyun"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("geolyun"));

        System.out.println(repository.findByName("Learn JS Now!"));
    }
}
