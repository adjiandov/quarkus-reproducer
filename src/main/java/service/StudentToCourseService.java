package service;

import java.util.Set;

public interface StudentToCourseService {
  void addStudentsToCourse(Long courseId, Set<Long> studentIds);

  void removeStudentsFromCourse(Long courseId, Set<Long> studentIds);
}
