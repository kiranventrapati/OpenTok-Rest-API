package com.openTok.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class VideoCallConstants {
	
	public static int APIKEY;
	public static String SECRECTKEY;
	public static String CERIFICATE_LOCATION;
	

	// Setter Methods
	@Value("${apiKey}")
	public void setApikey(int apiKey) {
		APIKEY = apiKey;
	}
	@Value("${secrectKey}")
	public void setSecrectkey(String secrectKey) {
		SECRECTKEY = secrectKey;
	}
	@Value("${cerificate.location}")
	public void setCERIFICATE_LOCATION(String cerificateLocation) {
		CERIFICATE_LOCATION = cerificateLocation;
	}
	
	

}
