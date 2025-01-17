package com.wkdrabbit.school.service;

import com.wkdrabbit.school.SchoolApplication;
import com.wkdrabbit.school.model.Course;
import com.wkdrabbit.school.model.Instructor;
import com.wkdrabbit.school.model.Student;
import com.wkdrabbit.school.repository.CourseRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest {


    @Autowired
    private CourseService courseService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void getCountStudentsInCourse() {
    }

    @Test
    public void deleteFound() {
        courseService.delete(1);
        assertEquals(5, courseService.findAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteNotFound() {
        courseService.delete(1000);
        assertEquals(5, courseService.findAll().size());
    }

    @Test
    public void findCourseById(){
        assertEquals("Data Science", courseService.findCourseById(1).getCoursename());
    }
}