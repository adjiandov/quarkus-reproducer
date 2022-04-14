package domain;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID")
  private Long Id;

  @Column(name = "NAME")
  private String name;

  @ManyToMany
  @JoinTable(name = "STUDENT_X_COURSE",
      joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
  )
  @Builder.Default
  private List<Student> students = new ArrayList<>();
}
