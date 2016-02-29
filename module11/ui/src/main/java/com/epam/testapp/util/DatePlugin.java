package com.epam.testapp.util;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 * This class contains plug-in for registering existing converter in system.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class DatePlugin implements PlugIn{
	
	
	    @Override
	    public void destroy() {

	    }
	    
	    /**
	     * This method initializes existing converter.
	     * 
	     * @param servlet
	     * @param config
	     */
	    @Override
	    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
	    	DateConverter converter = new DateConverter();
	        ConvertUtils.register(converter, Date.class);
	        
	    }

}
