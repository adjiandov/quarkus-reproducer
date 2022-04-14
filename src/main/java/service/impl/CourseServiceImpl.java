package service.impl;

import domain.Course;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.CourseRepository;
import service.CourseService;

@RequiredArgsConstructor
@Singleton
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  @Override
  @Transactional
  public Course save(Course course) {
    courseRepository.persist(course);
    return course;
  }

  @Override
  public Course getCourse(Long id) {
    return courseRepository.findById(id);
  }
}
