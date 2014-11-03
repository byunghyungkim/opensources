package com.luuf.core.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.luuf.core.IConstant;


/**
 * Execution Time Measuring Interceptor<br>
 * If execution time exceeded over 'executionDeltaThreshold', write info log for the request
 * @author junhyeok.choi@gmail.com
 *
 */
public class ExecutionTimeInterceptor implements HandlerInterceptor {

	protected final Log LOG = LogFactory.getLog(getClass());
	private final int executionDeltaThreshold = 3000;
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute(IConstant.REQUEST_STARTTIME);
		long endTime = System.currentTimeMillis();
		long executionDelta = endTime - startTime;
		
		if (modelAndView != null)
			modelAndView.addObject(IConstant.EXECUTION_DELTA, executionDelta);

		if (executionDelta > executionDeltaThreshold)
			LOG.warn("Execution Delta: " + executionDelta + " ms - " + request.getRequestURL() + "?" + StringUtils.defaultString(request.getQueryString(), ""));
		
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute(IConstant.REQUEST_STARTTIME, System.currentTimeMillis());
		return true;
	}

}