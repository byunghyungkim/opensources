package com.luuf.core.spring.dispatcher;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Main Servlet Dispatcher
 * @author junhyeok.choi@gmail.com
 *
 */
public class LuufDispatcher extends DispatcherServlet {

	private static final long serialVersionUID = 54846177243336373L;

	public LuufDispatcher() {
	}

	/**
	 * @param webApplicationContext
	 */
	public LuufDispatcher(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
	}
	
	

}
