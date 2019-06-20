package com.wkdrabbit.school.controller;

import com.wkdrabbit.school.model.Course;
import com.wkdrabbit.school.service.CourseService;
import com.wkdrabbit.school.service.StudentService;
import com.wkdrabbit.school.view.CountStudentsInCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses() {
        ArrayList<Course> myCourses = courseService.findAll();
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInCourses() {
        return new ResponseEntity<>(courseService.getCountStudentsInCourse(), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<?> deleteCourseById(@PathVariable long courseid) {
        courseService.delete(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/students/students", produces = {"applicatoin/json"})
    public ResponseEntity<?> listAllStudents(
            @PageableDefault(page = 0,
                            size = 5)
                    Pageable pageable){
        return new ResponseEntity<>(studentService.findAll(pageable), HttpStatus.OK);
    }
}
