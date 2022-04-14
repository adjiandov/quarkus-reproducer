package repository;

import domain.StudentToCourse;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class StudentToCourseRepository
    implements PanacheRepositoryBase<StudentToCourse, StudentToCourse.StudentToCourseId> {
}
