package com.openTok.dao;

import com.openTok.model.Device;
import com.openTok.model.Member;
import com.openTok.model.VideoCall;

public interface DAO {

	public VideoCall videoCalldetails(VideoCall videoCall);
	public VideoCall incomingCall(long videoCallId);
	public void addDevice(Device device);
	
	public void addMember(Member m);
	public Device findByDeviceToken(String deviceToken);
	public String getDeviceToken();
	

}
