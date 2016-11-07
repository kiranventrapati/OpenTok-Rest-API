package com.openTok.api.response;

import java.util.HashMap;
import java.util.Map;

public class ResponseStatus {


	  public static enum Status {
	    OK,
	    /* Auth Failures */
	    INVALID_CREDENTIALS,
	    LOGIN_FAILED,
	    ACCESS_DENIED,
	    ACCOUNT_LOCKED,
	    ACCOUNT_CLOSED,
	    EMAIL_NOT_REGISTERED, // break
	    INVALID_API_KEY, INVALID_AUTH_TOKEN, FB_LOGIN_FAILED, FB_USER_NOT_FOUND,
	    EMAIL_UNAVAILABLE, FB_USER_EXISTS, INVALID_MEMBER,
	    /* Validation Failure */
	    FAIL, CROSS_SITE_SCRIPT_ERROR, ANOTHER_SITTER_BOOKED, NO_BOOST_SLOT_AVAILABLE,
	    NO_SLOT_AVAILABLE,
	    /* Error */
	    ERROR, UNKNOWN_ERROR, PAYMENT_GENERIC_ERROR, CREDIT_CARD_INVALID,
	    CREDIT_CARD_TYPE_INVALID, CREDIT_CARD_INACTIVE, PAYMENT_SERVICE_UNAVAILABLE,
	    MUST_UPGRADE, PREFER_UPGRADE, INVALID_OS, BACKGROUND_CHECK_REPORT_INACTIVE_EXPIRED,
	    UNDERAGE_FEATURE_UNAVAILABLE, SOCIAL_GRAPH_NOT_BUILT_ERROR, FACEBOOK_NOT_CONNECTED,
	    INVALID_STATE, VIDEO_CALL_DISABLED, RECEIVER_NOT_OPTED_IN_FOR_VIDEO_CALL, 
	    /* BackupCareAPI Validations Failure */
	    //Stripe
	    STRIPE_EXCEPTION,
	    BACKUPCARE_COMMENT_SIZE, INVALID_BOOKING, BUC_INVALID_PARTNERKEY, INVALID_SITE,
	    INSUFFICIENT_CREDITS, GOOGLE_CRCM_LOGIN_NEEDED;
	  }

	  private static Map<Status, Integer> statusMap = new HashMap<Status, Integer>();
	  /**
	   * Defining status code map association.
	   */
	  static {
	    /* OK : 200 */
	    statusMap.put(Status.OK, 200);
	    /* Auth Failure : 1301 - 1399 */
	    statusMap.put(Status.INVALID_API_KEY, 1301);
	    statusMap.put(Status.INVALID_AUTH_TOKEN, 1302);
	    statusMap.put(Status.INVALID_CREDENTIALS, 1303);
	    statusMap.put(Status.LOGIN_FAILED, 1304);
	    statusMap.put(Status.ACCOUNT_LOCKED, 1305);
	    statusMap.put(Status.ACCOUNT_CLOSED, 1306);
	    statusMap.put(Status.EMAIL_NOT_REGISTERED, 1307);
	    statusMap.put(Status.FB_LOGIN_FAILED, 1308);
	    statusMap.put(Status.FB_USER_NOT_FOUND, 1309);
	    statusMap.put(Status.EMAIL_UNAVAILABLE, 1310);
	    statusMap.put(Status.FB_USER_EXISTS, 1311);
	    statusMap.put(Status.INVALID_MEMBER, 1312);
	    statusMap.put(Status.ACCESS_DENIED, 1313);
	    /* Validation Failure : 1401 - 1499 */
	    statusMap.put(Status.FAIL, 1401);
	    statusMap.put(Status.CROSS_SITE_SCRIPT_ERROR, 1402);
	    statusMap.put(Status.ANOTHER_SITTER_BOOKED, 1403);
	    statusMap.put(Status.INSUFFICIENT_CREDITS, 1404);
	    statusMap.put(Status.NO_BOOST_SLOT_AVAILABLE, 1405);
	    statusMap.put(Status.NO_SLOT_AVAILABLE, 1406);
	    /* Validation Failure : Payment / Credit card : 1501 - 1599 */
	    statusMap.put(Status.PAYMENT_GENERIC_ERROR, 1501);
	    statusMap.put(Status.CREDIT_CARD_TYPE_INVALID, 1502);
	    statusMap.put(Status.CREDIT_CARD_INVALID, 1503);
	    statusMap.put(Status.CREDIT_CARD_INACTIVE, 1504);
	    statusMap.put(Status.PAYMENT_SERVICE_UNAVAILABLE, 1505);
	    /* Error : 1801 - 1999 */
	    statusMap.put(Status.ERROR, 1801);
	    statusMap.put(Status.MUST_UPGRADE, 1802);
	    statusMap.put(Status.PREFER_UPGRADE, 1803);
	    statusMap.put(Status.INVALID_OS, 1804);
	    statusMap.put(Status.BACKGROUND_CHECK_REPORT_INACTIVE_EXPIRED, 1805);
	    statusMap.put(Status.UNDERAGE_FEATURE_UNAVAILABLE, 1806);
	    statusMap.put(Status.SOCIAL_GRAPH_NOT_BUILT_ERROR, 1807);
	    statusMap.put(Status.FACEBOOK_NOT_CONNECTED, 1808);
	    statusMap.put(Status.UNKNOWN_ERROR, 1999);
	    statusMap.put(Status.INVALID_STATE, 1809);    
	    /* BackupCare Validations Failure */
	    statusMap.put(Status.BACKUPCARE_COMMENT_SIZE, 1901);
	    statusMap.put(Status.INVALID_BOOKING, 1902);
	    statusMap.put(Status.BUC_INVALID_PARTNERKEY, 1903);
	    statusMap.put(Status.INVALID_SITE, 1904);
	    statusMap.put(Status.VIDEO_CALL_DISABLED, 1905);
	    statusMap.put(Status.RECEIVER_NOT_OPTED_IN_FOR_VIDEO_CALL, 1906);
	    /* Stripe Exception : 1601 */
	    statusMap.put(Status.STRIPE_EXCEPTION, 1601);
	    statusMap.put(Status.GOOGLE_CRCM_LOGIN_NEEDED, 1907);
	    
	  }

	  /**
	   * Method to get the default status code from status
	   * 
	   * @param args
	   */
	  public static Integer getStatusCodeByStatus(Status status) {
	    return statusMap.containsKey(status) ? statusMap.get(status) : null;
	  }

}
