package com.epam.testapp.util;

import javax.servlet.*;

import java.io.IOException;

import javax.servlet.Filter;

/**
 * This class contains filter for setting character encoding.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class EncodingFilter implements Filter {

	private String code;

	/**
	 * This method initializes filter with parameter of encoding.
	 * 
	 * @param fConfig
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		code = fConfig.getInitParameter("encoding");
	}

	/**
	 * realization of filter
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		request.setCharacterEncoding(code);
		response.setCharacterEncoding(code);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		//
	}
}
