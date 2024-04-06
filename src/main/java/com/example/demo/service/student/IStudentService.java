package com.example.demo.service.student;

import com.example.demo.model.entity.Student;
import com.example.demo.model.request.StudentRequest;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();
    void addStudent(StudentRequest s);

    void deleteStudent(String id);

    void editStudent();
}
