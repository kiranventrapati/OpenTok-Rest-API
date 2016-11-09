package com.openTok.api.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Success extends APIResponse {

	@JsonProperty
	private Map<String, Object> data;
	public static final Success EMPTY = new Success();

	/**
	 * Constructor for success response with status and data.
	 * 
	 * @param status
	 * @param data
	 */
	public Success(Map<String, Object> data) {
		super(ResponseStatus.Status.OK);
		this.data = data;
	}

	/**
	 * Empty success response
	 */
	public Success() {
		super(ResponseStatus.Status.OK);
		this.data = new HashMap<String, Object>();
	}
}
