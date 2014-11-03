package com.luuf.core.object;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Base object definition.
 * Every value object class must inherit this BaseObject class.
 * 
 * @author junhyeok.choi@gmail.com
 *
 */
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 3902957272714621481L;
	
	private long creationTime; 
	
	public BaseObject() {
		this.creationTime = System.currentTimeMillis();
	}
	
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * Java bean's fields description
	 * Please use with caution. This method uses reflection so it will cause performance issue.
	 * @return
	 */
	public String objectToString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
