package repository.impl;

import domain.StudentToCourse;
import java.util.Set;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.StudentToCourseRepository;

@Singleton
@RequiredArgsConstructor
public class StudentToCourseRepositoryImpl {
  private final StudentToCourseRepository studentToCourseRepository;

  @Transactional
  public void addStudentsToCourse(final Set<StudentToCourse> studentToCourses) {
    studentToCourseRepository.persist(studentToCourses);
  }

  @Transactional
  public void removeStudentsFromCourse(final Set<StudentToCourse> studentToCourses) {
    studentToCourses
        .stream()
        .map(s -> StudentToCourse.StudentToCourseId.builder().studentId(s.getStudentId()).courseId(s.getCourseId())
            .build())
        .forEach(studentToCourseRepository::deleteById);
  }

}
