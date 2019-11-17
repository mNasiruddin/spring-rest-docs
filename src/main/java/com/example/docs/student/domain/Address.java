package com.example.docs.student.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The address object contains main details about a Student address
 */
@ApiModel(value="AddressModel", description="Address model for the student", subTypes = {Country.class})
@Data
public class Address{

	/**
	 * country details of the student.
	 */
	@ApiModelProperty(value = "{\n" +
			"            \"code\" : \"US\",\n" +
			"            \"name\" : \"United States of america\"\n" +
			"        }",
			position = 0,
			example = "\"code\" : \"US\",\n" +
					"            \"name\" : \"United States of america\"",
			dataType = "Country",
			notes = "student country details")
	@NotNull(message ="country cannot be null")
	@JsonProperty("country")
	private Country country;

	/**
	 * city where student reside
	 */
	@ApiModelProperty(value = "charlotte", position = 1, example = "charlotte", dataType = "String", notes = "city")
	@NotEmpty(message ="city cannot be null/empty")
	@JsonProperty("city")
	private String city;

	/**
	 * street name where student reside.
	 */
	//@ApiModelProperty(value = "Street 1, charlotte", position = 2, example = "Street 1, charlotte", dataType = "String", notes = "street")
	@NotEmpty(message ="street cannot be null/empty")
	//@JsonProperty("street")
	private String street;

	/**
	 * state
	 */
	//@ApiModelProperty(value = "NC", position = 3, example = "NC", dataType = "String", notes = "state")
	@NotEmpty(message ="state cannot be null/empty")
	//@JsonProperty("state")
	private String state;
}