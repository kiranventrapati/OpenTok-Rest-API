package com.openTok.model;

import java.io.Serializable;
import java.util.Date;

public class VideoCall implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int caller;
	private int receiver;
	private String sessionId;
	private String callerToken;
	private String receiverToken;
	private Date whenCreated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCaller() {
		return caller;
	}

	public void setCaller(int caller) {
		this.caller = caller;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCallerToken() {
		return callerToken;
	}

	public void setCallerToken(String callerToken) {
		this.callerToken = callerToken;
	}

	public String getReceiverToken() {
		return receiverToken;
	}

	public void setReceiverToken(String receiverToken) {
		this.receiverToken = receiverToken;
	}

	public Date getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

}
