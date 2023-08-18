package com.cutyteddybear.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "geolyun"),
                new Course(2, "Learn DevOps", "geolyun"),
                new Course(3, "Learn Azure", "geolyun"),
                new Course(4, "Learn GCP", "geolyun")
        );
    }

}
