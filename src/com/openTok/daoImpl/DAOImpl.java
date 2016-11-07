package com.openTok.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.openTok.dao.DAO;
import com.openTok.model.Device;
import com.openTok.model.Member;
import com.openTok.model.VideoCall;
import com.openTok.utils.InstanceUtils;

public class DAOImpl implements DAO {

	SessionFactory factory;

	@Override
	public VideoCall videoCalldetails(VideoCall videoCall) {
    factory = InstanceUtils.getSessionFactoryInstance();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	session.save(videoCall);
	tx.commit();
	
	return videoCall;
	}

	@Override
	public VideoCall incomingCall(long videoCallId) {
		 factory = InstanceUtils.getSessionFactoryInstance();
			Session session = factory.openSession();
			VideoCall videoCall = (VideoCall) session.get(VideoCall.class, videoCallId);
			
		return videoCall;
	}

	@Override
	public void addDevice(Device device) {
		
		  factory = InstanceUtils.getSessionFactoryInstance();
			Session session = factory.openSession();
			
			Member m =(Member) session.get(Member.class,1);
			m.getDevice().add(device);	
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(m);
			tx.commit();
	
	}

	@Override
	public void addMember(Member m) {
		factory = InstanceUtils.getSessionFactoryInstance();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(m);
		tx.commit();
	}

	@Override
	public Device findByDeviceToken(String deviceToken) {
		
		factory = InstanceUtils.getSessionFactoryInstance();
		Session session = factory.openSession();
		    Query query =
		        session
		            .createQuery("select device from Device device where device.deviceToken = :token");
		    query.setParameter("token", deviceToken);
		    return (Device) query.uniqueResult();
	}


	

}
