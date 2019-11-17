package com.example.docs.student.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * The country object contains main details about a Student country
 */
@ApiModel(value="CountryModel", description="Country model for the student")
@Data
public class Country{

	/**
	 *  2 letter ISO country code.
	 */
	@ApiModelProperty(value = "us", position = 0, example = "us", dataType = "String", notes = "country code")
	@NotNull(message ="code cannot be null")
	@JsonProperty("code")
	private String code;

	/**
	 *  country name
	 */
	@ApiModelProperty(value = "country name", position = 1, example = "united states of america", dataType = "String", notes = "country name")
	@NotNull(message ="name cannot be null")
	@JsonProperty("name")
	private String name;
}