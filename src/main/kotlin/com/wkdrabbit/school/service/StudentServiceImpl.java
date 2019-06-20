package com.wkdrabbit.school.service;

import com.wkdrabbit.school.model.Course;
import com.wkdrabbit.school.model.Student;
import com.wkdrabbit.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studrepos;


    @Override
    public List<Student> findStudentByNameLike(String name, Pageable pageable) {
        List<Student> list = new ArrayList<>();
        studrepos.findByStudnameContainingIgnoreCase(name, pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Student> findAll(Pageable pageable) {
        List<Student> list = new ArrayList<>();
        studrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Student findStudentById(Long studentId) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void update(Student updateStudent, long studentid) {

    }


    @Override
    public void delete(long studentid) {
    }
}
