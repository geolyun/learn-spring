package com.CutyTeddyBear.springboot.learnjpaandhibernate.course;

import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.Course;
import com.CutyTeddyBear.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "geolyun"));
        repository.insert(new Course(2, "Learn Azure Now!", "geolyun"));
        repository.insert(new Course(3, "Learn JS Now!", "geolyun"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
    }
}
