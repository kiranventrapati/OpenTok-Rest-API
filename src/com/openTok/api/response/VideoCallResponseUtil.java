package com.openTok.api.response;

import java.util.HashMap;
import java.util.Map;

import com.openTok.model.VideoCall;

public class VideoCallResponseUtil {

	public static Map<String, Object> getVideoCallResponse(
			Map<String, Object> data, VideoCall videoCall, int apiKey) {

		HashMap<String, Object> general = new HashMap<String, Object>();
		general.put("videoCallId", videoCall.getId());
		general.put("memberId", videoCall.getCaller());
		general.put("apiKey", apiKey);
		general.put("sessionId", videoCall.getSessionId());
		general.put("callerToken", videoCall.getCallerToken());

		data.put("general", general);
		return data;
	}

	public static void getReceiveTokenResponse(Map<String, Object> data,
			VideoCall videoCall, int apiKey) {
		HashMap<String, Object> general = new HashMap<String, Object>();
		general.put("apiKey", apiKey);
		general.put("sessionId", videoCall.getSessionId());
		general.put("receiverToken", videoCall.getReceiverToken());
		data.put("general", general);
		
	}

}
