package service.impl;

import java.util.Set;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;
import mapper.ToCourseRelationsMapper;
import repository.impl.StudentToCourseRepositoryImpl;
import service.StudentToCourseService;

@RequiredArgsConstructor
@Singleton
public class StudentToCourseServiceImpl implements StudentToCourseService {
  private final StudentToCourseRepositoryImpl studentRepository;
  private final ToCourseRelationsMapper courseRelationsMapper;

  @Override
  public void addStudentsToCourse(Long courseId, Set<Long> studentIds) {
    final var associations = courseRelationsMapper
        .mapStudentAndCourseIdsToEntity(courseId, studentIds);

    studentRepository.addStudentsToCourse(associations);
  }

  @Override
  public void removeStudentsFromCourse(Long courseId, Set<Long> studentIds) {
    final var associations = courseRelationsMapper
        .mapStudentAndCourseIdsToEntity(courseId, studentIds);

    studentRepository.removeStudentsFromCourse(associations);

  }
}
