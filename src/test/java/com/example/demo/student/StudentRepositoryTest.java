package com.example.demo.student;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Autowired
    private CourseRepository underTestCourse;

    @BeforeEach
    void setUp(){
        Course c1 = new Course();
        c1.setName("Toan");
        c1.setSlot(1);

        Course c2 = new Course();
        c2.setName("Anh");
        c2.setSlot(2);

        Course c3 = new Course();
        c3.setName("Li");
        c3.setSlot(1);

        underTestCourse.save(c1);
        underTestCourse.save(c2);
        underTestCourse.save(c3);

        Student s1 = new Student();
        s1.setName("Hoang");
        s1.setAge(20);
        s1.setCourse(c1);

        Student s2 = new Student();
        s2.setName("Nguyen");
        s2.setAge(20);
        s2.setCourse(c2);

        Student s3 = new Student();
        s3.setName("Hihi");
        s3.setAge(20);
        s3.setCourse(c2);

        Student s4 = new Student();
        s4.setName("Minh");
        s4.setAge(20);
        s4.setCourse(c3);

        underTest.save(s1);
        underTest.save(s2);
        underTest.save(s3);
        underTest.save(s4);
    }



    @Test
    void itShouldCheckIfStudentExistName(){
        boolean exists = underTest.selectExistsName("Hihi");

        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfCourseHasMoreOneStudent(){
        boolean exists = underTestCourse.selectExistsCourseHasMoreOneStudent();

        assertThat(exists).isTrue();
    }
}
