package com.luuf.core.integration.twilio;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.luuf.core.spring.service.ServiceCore;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

/**
 * Twilio SMS sender
 * @author junhyeok.choi@gmail.com
 *
 */
@Service
public class TwilioSMS extends ServiceCore {

	private Properties props; 
	private String accountSid;
	private String authToken;
	private String phoneNo;
	
	/**
	 * Constructor
	 * Read SMSCredentials.properties
	 */
	public TwilioSMS() {
		props = new Properties();
		
		try {
			// read SMSCredentials.properties 
			props.load(getClass().getClassLoader().getResourceAsStream("SMSCredentials.properties"));
			
			accountSid = props.getProperty("account.sid");
			authToken = props.getProperty("auth.token");
			phoneNo = props.getProperty("phone.no");
		} catch (Exception e) {
			LOG.fatal("Unable to load SMSCredentials.properties file", e);
		}
	}
	
	/**
	 * Send a verification number code to phone
	 * @param phone
	 * @param verificationCode
	 * @return if success, true 
	 * @throws TwilioRestException
	 */
	public boolean sendVerificationSMS(String phone, int verificationCode) throws TwilioRestException {
		LOG.info("SENDING VERIFICATION SMS " + phone + " " + verificationCode);
		
		TwilioRestClient client = new TwilioRestClient(accountSid, authToken);
        Account account = client.getAccount();
        SmsFactory smsFactory = account.getSmsFactory();
        Map<String, String> smsParams = new HashMap<String, String>();
        
        smsParams.put("To", phone); 
        smsParams.put("From", phoneNo); 
        smsParams.put("Body", "NameTag verification Code - " + verificationCode);
        
        try {
			Sms sms = smsFactory.create(smsParams);
			sms.getStatus();
		} catch (TwilioRestException e) {
			LOG.fatal("Unable to send verification SMS", e);
			throw e;
		}
        
		return true;
	}
}
