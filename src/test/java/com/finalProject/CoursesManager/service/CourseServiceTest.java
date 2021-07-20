package com.finalProject.CoursesManager.service;

import com.finalProject.CoursesManager.model.Course;
import com.finalProject.CoursesManager.repository.CoursesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    private CourseService service;

    @Mock
    private CoursesRepository repository;

    @Test
    public void getAllCoursesTest() {
        service.getAllCourses();
        verify(repository).findAll();
    }

    @Test
    public void addCourseTest() {
        Course course = mock(Course.class);
        service.addCourse(course);
        verify(repository).save(course);
    }

    @Test
    public void updateCourseTest() {
        Course course = mock(Course.class);
        course.setID(2);
        service.updateCourse(2, course);
        verify(repository).save(course);
    }

    @Test
    public void deleteByIdTest() {
        int id = 2;
        service.deleteCourseById(id);
        verify(repository).deleteById(id);
    }

}