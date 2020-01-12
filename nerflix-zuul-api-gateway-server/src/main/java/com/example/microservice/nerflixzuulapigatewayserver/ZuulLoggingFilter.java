package com.example.microservice.nerflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;



//In Zuul we do more than just logging..we can implement security, rate limits... this will be a great way to implement all these
@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//this is for should this filter be excuted or not
	@Override
	public boolean shouldFilter() {
		
		return true; // we want this filter to run for every request
		
	}

	///here is where the real logic of filtering written
	@Override
	public Object run() throws ZuulException {
		//here we want to log the details of the request 
		
		
		//to get the current request.. this will give the http request ewhich is being handled
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("Reqeust -> {} request uri -> {} ", request, request.getRequestURI());
		
		return null;
	}

	//this to tell, when should filtering happen..should it be happening before the request is excuting or after it or when an error occer
	@Override
	public String filterType() {
		return "pre";
	}

	//if we have multiple zuul filters.. like securityFilter, logging filter...we can set priority here
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
//		return 0;
		return 1;
	}

}
