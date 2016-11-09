package com.openTok.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.ApnsService;
import com.openTok.api.response.APIResponse;
import com.openTok.api.response.Success;
import com.openTok.api.response.VideoCallResponseUtil;
import com.openTok.constants.VideoCallConstants;
import com.openTok.forms.MobileForm;
import com.openTok.model.Member;
import com.openTok.model.VideoCall;
import com.openTok.service.OpenTokService;
import com.openTok.serviceImpl.OpenTokServiceImpl;
import com.opentok.OpenTok;
import com.opentok.exception.OpenTokException;

@Controller
@RequestMapping(value = "/openTok", produces = "application/json")
public class OpenTokController {

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public @ResponseBody APIResponse addMember(

	@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws OpenTokException {
		HashMap<String, Object> data = new HashMap<String, Object>();

		Member m = new Member();
		m.setFirstName("Kiran");
		m.setLastName("Kumar");
		OpenTokService openTokService = new OpenTokServiceImpl();
		openTokService.addMember(m);
		return new Success(data);
	}

	@RequestMapping(value = "/call/member/{memberId}/{recieverId}", method = RequestMethod.GET)
	public @ResponseBody APIResponse testCall(
			@PathVariable("memberId") int memberId,
			@PathVariable("recieverId") int recieverId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws OpenTokException {

		HashMap<String, Object> data = new HashMap<String, Object>();
		OpenTok opentok = new OpenTok(VideoCallConstants.APIKEY,
				VideoCallConstants.SECRECTKEY);
		OpenTokService openTokService = new OpenTokServiceImpl();
		VideoCall videoCall = openTokService.createCallerSession(opentok,
				memberId, recieverId);
		VideoCallResponseUtil.getVideoCallResponse(data, videoCall,
				VideoCallConstants.APIKEY);
		return new Success(data);
	}

	@RequestMapping(value = "/incomingCall/{videoCallId}", method = RequestMethod.GET)
	public @ResponseBody APIResponse incomingCall(
			@PathVariable("videoCallId") long videoCallId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws OpenTokException {
		HashMap<String, Object> data = new HashMap<String, Object>();
		OpenTokService openTokService = new OpenTokServiceImpl();
		VideoCall videoCall = openTokService.incomingDetails(videoCallId);
		VideoCallResponseUtil.getReceiveTokenResponse(data, videoCall,
				VideoCallConstants.APIKEY);
		return new Success(data);
	}

	@RequestMapping(value = "/endOrRejectCall/{reason}", method = RequestMethod.GET)
	public @ResponseBody APIResponse endOrRejectCall(
			@PathVariable("reason") String reason,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		if (reason.equalsIgnoreCase("end")) {
			data.put("reason", reason);
		} else {
			data.put("reason", reason);
		}
		return new Success(data);
	}

	@RequestMapping(value = "/addDeviceToken", method = RequestMethod.POST)
	public @ResponseBody APIResponse addDeviceToken(
			@ModelAttribute("mobileForm") MobileForm mobileForm,
			BindingResult result, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		OpenTokService openTokService = new OpenTokServiceImpl();
		openTokService.addDevice(mobileForm);
		// Device device = openTokService.findByDeviceToken("abs");
		// Device device =
		// openTokService.findByDeviceToken(mobileForm.getDeviceToken());
		// if (device == null) {
		// openTokService.addDevice(mobileForm);
		// }
		HashMap<String, Object> data = new HashMap<String, Object>();

		return new Success(data);
	}

	@RequestMapping(value = "/send/videoCall/pushNotification", method = RequestMethod.GET)
	public @ResponseBody APIResponse sendVideoCallPusnNotification(
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		OpenTokService openTokService = new OpenTokServiceImpl();
		List<String> deviceTokens = openTokService.getDeviceToken();
		try {

			ApnsService service = null;
			String certFullPath = null;
			String payload = null;
			File file = null;
			certFullPath = request.getServletContext().getRealPath(
					VideoCallConstants.CERIFICATE_LOCATION);
			int badgeCount = 1;
			file = new File(certFullPath);
			if (!file.exists()) {
				System.out.println("File not exit");
			} else {
				service = APNS.newService().withCert(certFullPath, "wavelabs")
						.withSandboxDestination().build();
				String jsonData = "{\"message\":\"Hi Afsara\"}";
				payload = APNS.newPayload().badge(badgeCount)
						.alertBody(jsonData)
						.localizedKey("Soon you will recieve Video Call ")
						.toString();
				for (String deviceToken : deviceTokens) {

					ApnsNotification ser = service.push(deviceToken, payload);
					System.out.println(ser);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new Success();
	}
}
