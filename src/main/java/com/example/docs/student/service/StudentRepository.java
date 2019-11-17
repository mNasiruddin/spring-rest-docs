package com.example.docs.student.service;

import com.example.docs.student.domain.StudentRequest;
import com.example.docs.student.domain.StudentResponse;
import lombok.extern.log4j.Log4j2;

import java.util.*;

/**
 * The type Student repository.
 */
@Log4j2
public class StudentRepository implements Repository<StudentResponse, StudentRequest, String> {

  private Map<String, StudentResponse> map = new HashMap<>();
  private Set<String> compositeKey = new HashSet<>();

  private Mapper<StudentResponse, StudentRequest> mapper = new StudentMapper() {
  };

  @Override
  public StudentResponse findByMessageId(String id) {
    return map.getOrDefault(id, new StudentResponse());
  }

  @Override
  public StudentResponse save(StudentRequest studentRequest) {

    if (!compositeKey.contains(getCompositeKey(studentRequest))) {
      StudentResponse studentResponse = mapper.transform(studentRequest);
      studentResponse.setStudentId(UUID.randomUUID().toString());
      map.putIfAbsent(studentResponse.getStudentId(), studentResponse);
      compositeKey.add(getCompositeKey(studentRequest));
      log.info(studentResponse);
      return studentResponse;
    }
    throw new RuntimeException("Student with this name and email already exists");
  }

  @Override
  public boolean delete(String id) {
    return null != map.remove(id);
  }

  @Override
  public StudentResponse update(String id, StudentRequest studentRequest) {
    StudentResponse studentResponse = mapper.transform(studentRequest);
    studentResponse.setStudentId(id);
    return map.computeIfPresent(studentResponse.getStudentId(), (integer, studentResponse1) -> studentResponse);
  }


  private String getCompositeKey(StudentRequest studentRequest) {
    return studentRequest.getFirstName().trim() + studentRequest.getSurname().trim() + studentRequest.getEmail().trim();
  }
}
