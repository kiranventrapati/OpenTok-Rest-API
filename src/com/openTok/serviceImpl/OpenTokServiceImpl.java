package com.openTok.serviceImpl;

import java.util.Date;

import com.openTok.dao.DAO;
import com.openTok.dao.DAOFactory;
import com.openTok.forms.MobileForm;
import com.openTok.model.Device;
import com.openTok.model.Member;
import com.openTok.model.VideoCall;
import com.openTok.service.OpenTokService;
import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.exception.OpenTokException;

public class OpenTokServiceImpl implements OpenTokService {

	@Override
	public VideoCall createCallerSession(OpenTok opentok, int memberId,
			int recieverId) throws OpenTokException {

		DAO dao = DAOFactory.daoImplInstance();

		Session session = opentok.createSession();

		String sessionId = session.getSessionId();
		String callerToken = session.generateToken();
		String receiverToken = opentok.generateToken(sessionId);

		VideoCall videoCall = new VideoCall();

		videoCall.setCaller(memberId);
		videoCall.setCallerToken(callerToken);
		videoCall.setReceiver(recieverId);
		videoCall.setReceiverToken(receiverToken);
		videoCall.setSessionId(sessionId);
		videoCall.setWhenCreated(new Date());

		videoCall = dao.videoCalldetails(videoCall);

		return videoCall;
	}

	@Override
	public VideoCall incomingDetails(long videoCallId) {
		DAO dao = DAOFactory.daoImplInstance();
		VideoCall videoCall = dao.incomingCall(videoCallId);

		return videoCall;
	}

	@Override
	public void addDevice(MobileForm mobileForm) {
		DAO dao = DAOFactory.daoImplInstance();
		Device device = new Device();
        device.setDeviceToken(mobileForm.getDeviceToken());
        device.setDeviceType(mobileForm.getDeviceType());
        
        device.setTlm(new Date());
        device.setWhenCreated(new Date());
        device.setDerivedOsType(mobileForm.getOsType());
        dao.addDevice(device);
        
		

	}

	@Override
	public Device findByDeviceToken(String deviceToken) {
		DAO dao = DAOFactory.daoImplInstance();
		Device device = dao.findByDeviceToken(deviceToken);
		return device;
	}

	@Override
	public void addMember(Member m) {
		DAO dao = DAOFactory.daoImplInstance();
		dao.addMember(m);
		
	}

	@Override
	public void sendPushNotification() {
		
		
	}

	

}
