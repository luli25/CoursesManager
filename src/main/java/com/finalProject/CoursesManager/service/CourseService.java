package com.finalProject.CoursesManager.service;

import com.finalProject.CoursesManager.model.Course;
import com.finalProject.CoursesManager.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    private final CoursesRepository coursesRepo;

    public CourseService(CoursesRepository coursesRepo) {
        this.coursesRepo = coursesRepo;
    }

    public List<Course> getAllCourses() {
        return (List<Course>) coursesRepo.findAll();
    }

    public Course findCourseByName(String name) {
        return coursesRepo.findCourseByName(name)
                .orElseThrow(NoSuchElementException::new);
    }

    public Course addCourse(Course course) {
        return coursesRepo.save(course);
    }

    public Course updateCourse(int id,Course course) {
        return coursesRepo.save(course);
    }

    public void deleteCourseById(int id) {
        coursesRepo.deleteById(id);
    }
}
