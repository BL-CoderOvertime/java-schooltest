package com.wkdrabbit.school.controller;

import com.wkdrabbit.school.model.Course;
import com.wkdrabbit.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class, secure = false)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception {
        courseList = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() {
    }

    @Test
    public void getCountStudentsInCourses() {
    }

    @Test
    public void deleteCourseById() {
    }
}