package com.acme.learningcenter.learning.domain.service;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
//service es un intermedario, tremendo bounded context
public interface StudentService {
    //naming "get"
    //in repository "find"
    List<Student> getAll();
    Page<Student> getAll(Pageable pageable);
    Student getById(Long studentId);
    Student create(Student student);
    Student update(Long studentId, Student request);
    ResponseEntity<?> delete(Long studentId);
}
