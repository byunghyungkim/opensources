package com.luuf.core.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Chiper utility class
 * @author junhyeok.choi@gmail.com
 *
 */
public class ChiperUtil {

	/**
	 * Encodes str using BCrypt algorithm
	 * @param str
	 * @return BCrypted string
	 */
	public static String encodeBCrypt(String str) {
		return new BCryptPasswordEncoder().encode(str);
	}
	
	/**
	 * Matches str is identical with encodedStr
	 * @param rawStr
	 * @param encodedStr
	 * @return true if matched, or false
	 */
	public static boolean matchesBCrypt(String rawStr, String encodedStr) {
		return new BCryptPasswordEncoder().matches(rawStr, encodedStr);
	}

}
