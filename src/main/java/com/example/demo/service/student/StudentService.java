package com.example.demo.service.student;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Student;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(StudentRequest s){
        Course course = courseRepository.findById(s.getCourseId()).orElse(null);
        if(course != null) {
            Student student = new Student();
            student.setName(s.getName());
            student.setAge(s.getAge());
            student.setCourse(course);
            studentRepository.save(student);
            course.setSlot(course.getSlot() + 1);
            courseRepository.save(course);
        }
    }

    @Override
    public void deleteStudent(String id){
        studentRepository.findById(UUID.fromString(id))
                .ifPresent(student -> {
                    courseRepository.findById(student.getCourse().getId())
                                    .ifPresent(course -> {
                                        course.setSlot(course.getSlot() - 1);
                                    });
                    studentRepository.delete(student);
                });
    }

    @Override
    public void editStudent(){

    }
}
