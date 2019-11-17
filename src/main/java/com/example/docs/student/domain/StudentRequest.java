package com.example.docs.student.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The student request object contains main details about the fields required to create Student
 */
@ApiModel(value="Student Request Model", description="Student Request model for the documentation", subTypes = {Address.class, List.class, PhoneNumber.class})
@Data
public class StudentRequest {

	/**
	 * first name of the student.
	 */
	@ApiModelProperty(value = "john", position = 0, example = "John", dataType = "String", notes = "student firstname")
	@NotEmpty(message ="firstname cannot be null/empty")
	@JsonProperty("firstname")
	private String firstName;

	/**
	 * surname of the student.
	 */
	@ApiModelProperty(value = "paul", position = 1, example = "Paul", dataType = "String", notes = "student surname")
	@NotEmpty(message ="surname cannot be null/empty")
	@JsonProperty("surname")
	private String surname;

	/**
	 * address of the student.
	 */
	@ApiModelProperty(value = "{\n" +
			"        \"street\": \"Street 1, charlotte\",\n" +
			"        \"city\" : \"charlotte\",\n" +
			"        \"state\" : \"NC\",\n" +
			"        \"country\" : {\n" +
			"            \"code\" : \"US\",\n" +
			"            \"name\" : \"United States of america\"\n" +
			"        }\n" +
			"    }",
			position = 2, example = "{\n" +
			"        \"street\": \"Street 1, charlotte\",\n" +
			"        \"city\" : \"charlotte\",\n" +
			"        \"state\" : \"NC\",\n" +
			"        \"country\" : {\n" +
			"            \"code\" : \"US\",\n" +
			"            \"name\" : \"United States of america\"\n" +
			"        }\n" +
			"    }",
			dataType = "String",
			notes = "student address")
	@NotNull(message ="address cannot be null")
	@JsonProperty("address")
	private Address address;

	/**
	 * school name of the student.
	 */
	@ApiModelProperty(value = "St Cathedral school", position = 3, example = "St Cathedral school", dataType = "String", notes = "student school")
	@NotEmpty(message ="school cannot be null/empty")
	@JsonProperty("school")
	private String school;

	/**
	 * district of the student.
	 */
	@ApiModelProperty(value = "leinster", position = 4, example = "leinster", dataType = "String", notes = "student district")
	@NotEmpty(message ="district cannot be null/empty")
	@JsonProperty("district")
	private String district;

	/**
	 * subjects taken by the student.
	 */
	@ApiModelProperty(value = "[\n" +
			"        {\n" +
			"            \"id\" : 1212,\n" +
			"            \"name\": \"asa\",\n" +
			"        },\n" +
			"        {\n" +
			"            \"id\" : 1212,\n" +
			"            \"name\": \"asa\",\n" +
			"        },\n" +
			"    ]", position = 5, example = "[\n" +
			"        {\n" +
			"            \"id\" : 1212,\n" +
			"            \"name\": \"asa\",\n" +
			"        },\n" +
			"        {\n" +
			"            \"id\" : 1212,\n" +
			"            \"name\": \"asa\",\n" +
			"        },\n" +
			"    ]", dataType = "List<SubjectsItem>", notes = "student subjects")
	@NotEmpty(message ="subjects cannot be null")
	@JsonProperty("subjects")
	private List<SubjectsItem> subjects;

	/**
	 * Phone number of the student.
	 */
	@ApiModelProperty(value = "{\n" +
			"        \"internationalcode\" : \"+353\",\n" +
			"        \"localnumber\" : \"123456789\"\n" +
			"    }", position = 6, example = "{\n" +
			"        \"internationalcode\" : \"+353\",\n" +
			"        \"localnumber\" : \"123456789\"\n" +
			"    }", dataType = "PhoneNumber", notes = "student phonenumber")
	@NotNull(message ="phone number cannot be null")
	@JsonProperty("phonenumber")
	private PhoneNumber phonenumber;

	/**
	 * email of the student.
	 */
	@ApiModelProperty(value = "john.paul@unkown.com", position = 7, example = "John.Paul@unkown.com", dataType = "String", notes = "student email")
	@Email
	@NotEmpty(message ="email cannot be null/empty")
	@JsonProperty("email")
	private String email;
}