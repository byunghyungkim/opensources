package com.luuf.core.utils;

import java.util.zip.CRC32;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

/**
 * String Utility based on org.apache.commons.lang3.StringUtils
 * @author junhyeok.choi@gmail.com
 *
 */
public class StringUtil extends StringUtils{
	
	/**
	 * Returns CRC32 value of the String str
	 * @param str
	 * @return CRC32
	 */
	public static String getCRC32(String str) {
		CRC32 crc32 = new CRC32();
		crc32.update(str.getBytes());
		Long value = crc32.getValue();
		return value.toString();
	}
	
	/**
	 * Returns obj.toString()
	 * @param obj
	 * @return "" if obj is null, 
	 */
	public static String defaultString(Object obj) {
		if (obj == null)
			return new String("");
		
		return defaultString(obj.toString());
	}
	
	/**
	 * Returns obj.toString(), if obj is null return str
	 * @param obj
	 * @param str
	 * @return str if obj is null, 
	 */
	public static String defaultString(Object obj, String str) {
		if (obj == null)
			return str;
		
		return defaultString(obj.toString(), str);
	}
	
	public static String toJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
