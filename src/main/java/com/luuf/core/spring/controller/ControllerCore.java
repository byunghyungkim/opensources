package com.luuf.core.spring.controller;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.luuf.core.IConstant;

public class ControllerCore {

	protected final Log LOG = LogFactory.getLog(getClass());
	
	@SuppressWarnings("unchecked")
	protected void debugParameters(HttpServletRequest req) {
		Enumeration<String> en = req.getParameterNames();
		String name;
		
		while (en.hasMoreElements()) {
			name = en.nextElement();
			LOG.info(name + ":" + req.getParameter(name));
		}
		
		LOG.info("---------------------------------------");
	}
	
	/**
	 * Mark an error & cause to Model Attribute
	 * @param model
	 * @param cause
	 */
	protected void markError(Model model, String cause) {
		model.addAttribute(IConstant.ERROR_CAUSE, cause);
	}
	
	/**
	 * Mark an error & cause to Model Attribute
	 * @param model
	 * @param cause
	 */
	protected void markError(ModelAndView mav, String cause) {
		mav.addObject(IConstant.ERROR_CAUSE, cause);
	}
}
