package support;

import domain.Course;
import domain.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestObjectGenerator {
  public static Student generateStudent1() {
    Student s = new Student();

    s.setName("George");
    s.setLastName("Jackson");

    return s;
  }

  public static Student generateStudent2() {
    Student s = new Student();

    s.setName("Bob");
    s.setLastName("Smith");

    return s;
  }

  public static Course generateCourse() {
    Course c = new Course();

    c.setName("Quarkus");

    return c;
  }
}
