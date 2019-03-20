package com.userdetails;

import org.springframework.web.servlet.support.*;

/**
 * 
 *
 * @author Srinivas Gudipati
 * @version 1.0
 * @since 2019-03-20
 * This class Contains all the WebConfigration FIles
 */
public class WebAppConfigIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
}
