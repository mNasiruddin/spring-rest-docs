package com.example.docs.student.service;

import com.example.docs.student.domain.StudentRequest;
import com.example.docs.student.domain.StudentResponse;

/**
 * The interface Student mapper.
 */
public interface StudentMapper extends Mapper<StudentResponse, StudentRequest> {

    @Override
    default StudentResponse transform(StudentRequest studentRequest) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(studentRequest.getFirstName());
        studentResponse.setSurname(studentRequest.getSurname());
        studentResponse.setDistrict(studentRequest.getDistrict());
        studentResponse.setEmail(studentRequest.getEmail());
        studentResponse.setAddress(studentRequest.getAddress());
        studentResponse.setPhonenumber(studentRequest.getPhonenumber());
        studentResponse.setSchool(studentRequest.getSchool());
        studentResponse.setSubjects(studentRequest.getSubjects());
        return studentResponse;
    }
}
