package mapper;

import domain.StudentToCourse;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Singleton;

@Singleton
public class ToCourseRelationsMapper {
  public Set<StudentToCourse> mapStudentAndCourseIdsToEntity(Long courseId, Set<Long> studentIds) {
    return studentIds.stream()
        .map(studentId -> StudentToCourse.builder()
            .studentId(studentId)
            .courseId(courseId).build())
        .collect(Collectors.toSet());
  }
}
