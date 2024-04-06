package com.example.demo.repository;

import com.example.demo.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(
            "select case when count(c) > 0 then " +
                    "true else false end " +
                    "from Course c " +
                    "where c.slot > 1"
    )
    Boolean selectExistsCourseHasMoreOneStudent();
}
