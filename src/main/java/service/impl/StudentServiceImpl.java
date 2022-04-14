package service.impl;

import domain.Student;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.StudentRepository;
import service.StudentService;

@RequiredArgsConstructor
@Singleton
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  @Transactional
  public Student save(Student student) {
    studentRepository.persist(student);
    return student;
  }
}
