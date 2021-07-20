package com.finalProject.CoursesManager.controller;

import com.finalProject.CoursesManager.model.Course;
import com.finalProject.CoursesManager.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @InjectMocks
    CourseController courseController;

    @Mock
    CourseService service;

    @Mock
    Course course;

    @Test
    public void findCourseByNameTest() {
        String name = "test";
        when(service.findCourseByName(name)).thenReturn(course);
        assertEquals(courseController.findCourseByName(name).getBody(), course);
    }

    @Test
    public void getAllCoursesTest() {
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        when(service.getAllCourses()).thenReturn(courses);
        assertEquals(courseController.getAllCourses().getBody().size(), courses.size());
    }

    @Test
    public void addCourse() {
        assertEquals(courseController.addCourse(course).getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void updateCourseTest() {
        int id = 1;
        course.setID(id);
        when(service.updateCourse(id, course)).thenReturn(course);
        assertEquals(courseController.updateCourse(id, course).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deleteCourseById() {
        int id = 1;
        assertEquals(courseController.deleteCourseById(id).getStatusCode(), HttpStatus.NO_CONTENT);
    }
}