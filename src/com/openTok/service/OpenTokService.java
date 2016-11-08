package com.openTok.service;

import com.openTok.forms.MobileForm;
import com.openTok.model.Device;
import com.openTok.model.Member;
import com.openTok.model.VideoCall;
import com.opentok.OpenTok;
import com.opentok.exception.OpenTokException;


public interface OpenTokService 
{
	VideoCall createCallerSession(OpenTok opentok,int memberId,int recieverId) throws OpenTokException;
    
	VideoCall incomingDetails(long videoCallId);
	
	void addDevice(MobileForm mobileForm);

	Device findByDeviceToken(String deviceToken);
	
	void addMember(Member m);

	String getDeviceToken();

	
}
