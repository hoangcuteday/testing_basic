package com.example.demo.web.rest;

import com.example.demo.model.request.CourseRequest;
import com.example.demo.service.course.ICourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public void getCourse(){

    }

    @PostMapping
    public void addCourse(@RequestBody CourseRequest c){
            courseService.addCourse(c);
    }
}
