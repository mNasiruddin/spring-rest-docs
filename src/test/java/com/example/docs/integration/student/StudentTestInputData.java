package com.example.docs.integration.student;

import com.example.docs.student.domain.*;

import java.util.Arrays;
import java.util.List;

public class StudentTestInputData {

    private static final String URI = "/api/v1/student/";

    public static StudentRequest newStudentRequest() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("Joe");
        studentRequest.setSurname("Bloggs");
        studentRequest.setEmail("joe.bloggs@example.com");
        studentRequest.setAddress(getAddress());
        studentRequest.setDistrict("NC");
        studentRequest.setPhonenumber(getPhoneNumber());
        studentRequest.setSchool("St Catherdal School");
        studentRequest.setSubjects(getSubjects());
        return studentRequest;
    }

    public static StudentRequest updateStudentRequest() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("John");
        studentRequest.setSurname("Paul");
        studentRequest.setEmail("john.paul@example.com");
        studentRequest.setAddress(getAddress());
        studentRequest.setDistrict("NC");
        studentRequest.setPhonenumber(getPhoneNumber());
        studentRequest.setSchool("St Catherdal School");
        studentRequest.setSubjects(getSubjects());
        return studentRequest;
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setCountry(getCountry());
        address.setCity("dublin");
        address.setState("leinster");
        address.setStreet("O'Connell street");
        return address;
    }

    public static Country getCountry() {
        Country country = new Country();
        country.setCode("US");
        country.setName("United States of America");
        return country;
    }

    public static List<SubjectsItem> getSubjects() {
        SubjectsItem maths = new SubjectsItem();
        maths.setId(1234);
        maths.setName("maths");

        SubjectsItem science = new SubjectsItem();
        science.setId(4567);
        science.setName("science");
        return Arrays.asList(maths, science);
    }

    public static PhoneNumber getPhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setInternationalcode("+1");
        phoneNumber.setLocalnumber("12345678");
        return phoneNumber;
    }

    public static String getURI() {
        return URI;
    }
}
