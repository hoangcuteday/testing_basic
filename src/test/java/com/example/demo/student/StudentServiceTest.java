package com.example.demo.student;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class StudentServiceTest {
    @Autowired
//    @Mock
    private StudentRepository studentRepository;
    @Autowired
//    @Mock
    private CourseRepository courseRepository;
    private StudentService underTest;

    private List<Student> studentList;


    @BeforeEach()
    void setUp() {
        Course c1 = new Course();
        c1.setName("Toan");
        c1.setSlot(1);

        Course c2 = new Course();
        c2.setName("Anh");
        c2.setSlot(2);

        Course c3 = new Course();
        c3.setName("Li");
        c3.setSlot(1);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

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

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);

        studentList = new ArrayList<>(Arrays.asList(s1,s2,s3,s4));
//        when(studentRepository.findAll()).thenReturn(studentList);

        underTest = new StudentService(studentRepository, courseRepository);
    }


    @Test
    void canGetAllStudents() {
        underTest.getAllStudents();

        verify(studentRepository).findAll();
    }

    @Test
    void checkSizeListStudent() {
        List<Student> students = underTest.getAllStudents();

        Assertions.assertEquals(4, students.size());
    }
}
