package com.example.demo.web.rest;

import com.example.demo.model.request.StudentRequest;
import com.example.demo.service.student.IStudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public void getStudent(){

    }

    @PostMapping
    public void addStudent(@RequestBody StudentRequest s){
           studentService.addStudent(s);
    }

    @DeleteMapping
    public void deleteStudent(String id){
          studentService.deleteStudent(id);
    }

    @PutMapping
    public void editStudent(){

    }
}
