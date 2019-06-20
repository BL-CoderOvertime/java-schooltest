package com.wkdrabbit.school.service;

import com.wkdrabbit.school.model.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findStudentByNameLike(String name, Pageable pageable);

    List<Student> findAll(Pageable pageable);

    Student findStudentById(Long studentId);

    Student save(Student newStudent);

    void update(Student updateStudent, long studentid);

    void delete(long studentid);
}
