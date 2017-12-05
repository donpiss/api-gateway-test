package com.example.apigateway.config;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response = ctx.getResponse();
		/*
		 * HttpServletRequest request = ctx.getRequest();
		 * 
		 * 
		 * System.out.println(request.getMethod());
		 * System.out.println(request.getRequestURL().toString()); Enumeration
		 * headerNames = request.getHeaderNames(); while (headerNames.hasMoreElements())
		 * { String key = (String) headerNames.nextElement(); String value =
		 * request.getHeader(key); System.out.println(key + " -- " + value); }
		 * 
		 * System.out.println(request.getRemoteAddr());
		 * System.out.println(request.getRemoteHost());
		 * System.out.println(request.getRemotePort());
		 * System.out.println(request.getRemoteUser());
		 * System.out.println(response.getStatus());
		 * 
		 * System.out.println("Using Post Filter");
		 * System.out.println(ctx.getResponseStatusCode()); //
		 * System.out.println(ctx.getResponseBody()); //
		 * log.info(String.format("%s request to %s", request.getMethod(), //
		 * request.getRequestURL().toString())); //
		 * log.debug(String.format("%s request to %s", request.getMethod(), //
		 * request.getRequestURL().toString())); //
		 * log.warn(String.format("%s request to %s", request.getMethod(), //
		 * request.getRequestURL().toString()));
		 */
		log.info("PostFilter: " + String.format("response's content type is %s", response.getStatus()));
		return null;
	}

}
