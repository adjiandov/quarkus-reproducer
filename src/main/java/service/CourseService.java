package service;

import domain.Course;

public interface CourseService {
  Course save(Course course);

  Course getCourse(Long id);
}
