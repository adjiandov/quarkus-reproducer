package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@IdClass(StudentToCourse.StudentToCourseId.class)
@Table(name = "STUDENT_X_COURSE")
public class StudentToCourse {

  @Id
  @Column(name = "STUDENT_ID")
  private Long studentId;

  @Id
  @Column(name = "COURSE_ID")
  private Long courseId;

  @SuperBuilder
  @NoArgsConstructor
  public static class StudentToCourseId
      implements Serializable {
    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "COURSE_ID")
    private Long courseId;
  }
}