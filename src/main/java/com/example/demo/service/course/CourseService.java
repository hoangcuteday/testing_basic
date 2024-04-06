package com.example.demo.service.course;

import com.example.demo.model.entity.Course;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void getCourse(){

    }

    @Override
    public void addCourse(CourseRequest c){
        Course course = new Course();
        course.setName(c.getName());
        course.setSlot(0);
        courseRepository.save(course);
    }
}
