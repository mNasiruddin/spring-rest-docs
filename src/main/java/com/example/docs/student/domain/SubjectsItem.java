package com.example.docs.student.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * The subject item object contains main details about a Student subjects
 */
@ApiModel(value="SubjectsItemModel", description="SubjectsItem model for the student")
@Data
public class SubjectsItem{

	/**
	 *  subject name
	 */
	@ApiModelProperty(value = "maths",
			position = 0,
			example = "maths",
			dataType = "String",
			notes = "subject name")
	@NotNull(message ="name cannot be null")
	@JsonProperty("name")
	private String name;

	/**
	 *  subject id
	 */
	@ApiModelProperty(value = "12345",
			position = 1,
			example = "12345",
			dataType = "integer",
			notes = "subject id")
	@NotNull(message ="id cannot be null")
	@JsonProperty("id")
	private int id;
}