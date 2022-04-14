package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.TestObjectGenerator.generateCourse;
import static support.TestObjectGenerator.generateStudent1;
import static support.TestObjectGenerator.generateStudent2;

import io.quarkus.test.junit.QuarkusTest;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@QuarkusTest
@RequiredArgsConstructor
public class StudentToCourseServiceImplTest {
  private final StudentService studentService;
  private final CourseService courseService;
  private final StudentToCourseService studentToCourseService;

  @Test
  void testAddStudentsToCourse() {
    var course = generateCourse();
    var student1 = generateStudent1();
    var student2 = generateStudent2();

    course = courseService.save(course);
    student1 = studentService.save(student1);
    student2 = studentService.save(student2);

    studentToCourseService.addStudentsToCourse(course.getId(),
        Set.of(student1.getId(), student2.getId()));
    course = courseService.getCourse(course.getId());

    assertTrue(course.getStudents().size() > 0);
  }

  @Test
  void testRemoveStudentsFromCourse() {
    var course = generateCourse();
    var student1 = generateStudent1();
    var student2 = generateStudent2();

    course = courseService.save(course);
    student1 = studentService.save(student1);
    student2 = studentService.save(student2);

    studentToCourseService.addStudentsToCourse(course.getId(),
        Set.of(student1.getId(), student2.getId()));
    final var updatedCourse = courseService.getCourse(course.getId());
    assertTrue(updatedCourse.getStudents().size() > 0);

    studentToCourseService.removeStudentsFromCourse(course.getId(),
        Set.of(student1.getId()));
    final var result = courseService.getCourse(course.getId());

    assertEquals(1, result.getStudents().size());
  }

}
