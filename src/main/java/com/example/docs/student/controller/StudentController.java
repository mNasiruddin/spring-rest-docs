package com.example.docs.student.controller;

import com.example.docs.constant.SwaggerApiDocConstants;
import com.example.docs.student.domain.StudentRequest;
import com.example.docs.student.domain.StudentResponse;
import com.example.docs.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * The type Student controller.
 */
@Api(value = "/api/v1/student", description = "Operations about student",
        produces ="application/json",
        tags = "Student")
@RestController
@RequestMapping("/api/v1/student")
@Log4j2
public class StudentController {

  private final StudentService studentService;

  /**
   * Instantiates a new Student controller.
   *
   * @param studentService the student service
   */
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * Create student response.
   *
   * @param studentRequest the student request
   * @return the student response
   */

  @ApiOperation(
          value = "Takes in a student request and creates a new student in the system",
          nickname = "create student",
          notes = "Validates if student request is correct and then creates a new student and returns the response with student id" +
                  "for future processing",
          response = StudentResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = SwaggerApiDocConstants.SUCCESS_201, response = StudentResponse.class),
          @ApiResponse(code = 400, message = SwaggerApiDocConstants.BAD_REQUEST_400),
          @ApiResponse(code = 500, message = SwaggerApiDocConstants.SERVER_ERROR_500)})
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse create(@RequestBody StudentRequest studentRequest) {
    log.debug("creating student : {}", studentRequest);
    return studentService.create(studentRequest);
  }

  /**
   * Get student response.
   *
   * @param studentId the student id
   * @return the student response
   */
  @ApiOperation(
          value = "Takes in a student id and returns the student if it exists",
          nickname = "find student",
          notes = "Validates the requested student id and finds the student from the id, if exists then returns",
          response = StudentResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = SwaggerApiDocConstants.SUCCESS_200, response = StudentResponse.class),
          @ApiResponse(code = 400, message = SwaggerApiDocConstants.BAD_REQUEST_400),
          @ApiResponse(code = 500, message = SwaggerApiDocConstants.SERVER_ERROR_500)})
  @GetMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public StudentResponse get(@PathVariable String studentId) {
    log.debug("getting studentId : {}", studentId);
    return studentService.findByMessageId(studentId);
  }

  /**
   * Delete boolean.
   *
   * @param studentId the student id
   * @return the boolean
   */
  @ApiOperation(
          value = "Takes in a student id and returns 200 if it exists and successfully deleted from the system",
          nickname = "delete student",
          notes = "Validates the requested student id and finds the student from the id, if exists then deletes from the system and returns 200",
          response = Boolean.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = SwaggerApiDocConstants.SUCCESS_200, response = Boolean.class),
          @ApiResponse(code = 204, message = SwaggerApiDocConstants.SUCCESS_204),
          @ApiResponse(code = 400, message = SwaggerApiDocConstants.BAD_REQUEST_400),
          @ApiResponse(code = 500, message = SwaggerApiDocConstants.SERVER_ERROR_500)})
  @DeleteMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public boolean delete(@PathVariable String studentId) {
    log.debug("deleting studentId : {}", studentId);
    return studentService.deleteMessage(studentId);
  }

  /**
   * Update student response.
   *
   * @param studentId      the student id
   * @param studentRequest the student request
   * @return the student response
   */

  @ApiOperation(
          value = "Takes in a student request at student id endpoint and it does full replace of existing student in the system",
          nickname = "update student",
          notes = "Validates if student request id is correct and then replace existing student with requested student information",
          response = StudentResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = SwaggerApiDocConstants.SUCCESS_200, response = StudentResponse.class),
          @ApiResponse(code = 204, message = SwaggerApiDocConstants.SUCCESS_204),
          @ApiResponse(code = 400, message = SwaggerApiDocConstants.BAD_REQUEST_400),
          @ApiResponse(code = 500, message = SwaggerApiDocConstants.SERVER_ERROR_500)})
  @PutMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public StudentResponse update(@PathVariable String studentId, @RequestBody StudentRequest studentRequest) {
    log.debug("updating studentId with student data : {} {}", studentId, studentRequest);
    return studentService.update(studentId, studentRequest);
  }
}
