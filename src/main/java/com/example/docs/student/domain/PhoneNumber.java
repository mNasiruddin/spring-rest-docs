package com.example.docs.student.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * The phonenumber object contains main details about a Student phone number
 */
@ApiModel(value="PhoneNumberModel", description="PhoneNumber model for the student")
@Data
public class PhoneNumber {

	/**
	 *  international country code.
	 */
	@ApiModelProperty(value = "+1", position = 0, example = "+1", dataType = "String", notes = "international dialing code")
	@NotNull(message ="internationalcode cannot be null")
	@JsonProperty("internationalcode")
	private String internationalcode;

	/**
	 *  local number of the student.
	 */
	@ApiModelProperty(value = "704123456", position = 1, example = "704123456", dataType = "String", notes = "area code followed by local number")
	@NotNull(message ="localnumber cannot be null")
	@JsonProperty("localnumber")
	private String localnumber;
}