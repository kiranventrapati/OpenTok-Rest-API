package com.openTok.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

	@JsonProperty
	private int statusCode;
	@JsonProperty
	private String status;

	public APIResponse(ResponseStatus.Status status) {
		this.status = status.name();
		this.statusCode = ResponseStatus.getStatusCodeByStatus(status);
	}
}
