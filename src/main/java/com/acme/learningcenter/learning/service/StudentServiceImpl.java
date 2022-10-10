package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.persistence.StudentRepository;
import com.acme.learningcenter.learning.domain.service.StudentService;
import com.acme.learningcenter.shared.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//this is of persistence
import javax.validation.Validator;
import java.util.List;

//capa de servicio
//this is the esteriotipo, el de abajo
@Service
public class StudentServiceImpl implements StudentService {

    //no participa en escenarios de herencia
    private static final String ENTITY = "Student";

    private final StudentRepository studentRepository;

    private final Validator validator;

    public StudentServiceImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
//        si no lo encuentra provoca una excepcioon
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,studentId));
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student update(Long studentId, Student request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return null;
    }
}
