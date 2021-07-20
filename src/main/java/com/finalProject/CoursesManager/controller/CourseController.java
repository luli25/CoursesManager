package com.finalProject.CoursesManager.controller;

import com.finalProject.CoursesManager.model.Course;
import com.finalProject.CoursesManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Course> findCourseByName(@PathVariable("name") String name) {
        Course course = courseService.findCourseByName(name);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody @DateTimeFormat(pattern = "MM-dd-yyyy") Course course) {
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody @DateTimeFormat(pattern = "MM-dd-yyyy") Course course) {
         courseService.updateCourse(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("id") int id) {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
