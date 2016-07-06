package com.jon.web.util;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

public class WebUtil {

	/**
	 * HttpServletResponse
	 * 无法使用
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	}

}
