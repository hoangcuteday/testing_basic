package com.example.demo.repository;

import com.example.demo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query(
            "select case when count(s) > 0 then " +
                    "true else false end " +
                    "from Student s " +
                    "where s.name = ?1"
    )
    Boolean selectExistsName(String name);

    List<Student> findAll();
}
