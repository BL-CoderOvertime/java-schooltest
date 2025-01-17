package com.wkdrabbit.school.service;

import com.wkdrabbit.school.model.Course;
import com.wkdrabbit.school.repository.CourseRepository;
import com.wkdrabbit.school.view.CountStudentsInCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courserepos;

    @Override
    public ArrayList<Course> findAll() {
        ArrayList<Course> list = new ArrayList<>();
        courserepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<CountStudentsInCourses> getCountStudentsInCourse() {
        return courserepos.getCountStudentsInCourse();
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException {
        if (courserepos.findById(id).isPresent()) {
            courserepos.deleteCourseFromStudcourses(id);
            courserepos.deleteById(id);
        } else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Course findCourseById(long id) {
        return courserepos.findById(id).get();
    }
}
