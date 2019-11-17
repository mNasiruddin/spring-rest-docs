package com.example.docs.student.service;

import com.example.docs.student.domain.StudentRequest;
import com.example.docs.student.domain.StudentResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * The type Student service.
 */
@Log4j2
@Service
public class StudentServiceImpl implements StudentService {

  private StudentRepository studentRepository;

  /**
   * Instantiates a new Student service.
   */
  StudentServiceImpl() {
    this.studentRepository = new StudentRepository();
  }

  @Override
  public StudentResponse create(StudentRequest studentRequest) {
    return studentRepository.save(studentRequest);
  }

  @Override
  public StudentResponse findByMessageId(String messageId) {
    return studentRepository.findByMessageId(messageId);
  }

  @Override
  public boolean deleteMessage(String messageId) {
    return studentRepository.delete(messageId);
  }

  @Override
  public StudentResponse update(String studentId, StudentRequest studentRequest) {
    return studentRepository.update(studentId, studentRequest);
  }
}
