package com.finalProject.CoursesManager.repository;

import com.finalProject.CoursesManager.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesRepository extends CrudRepository<Course, Integer> {

    @Query
    Optional<Course> findCourseByName(String name);
}
