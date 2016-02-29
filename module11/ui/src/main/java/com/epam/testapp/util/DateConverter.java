package com.epam.testapp.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;
import org.apache.log4j.Logger;


/**
 * This class contains method for converting date from string to util.date when
 * it happens to upload data from client side to database.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class DateConverter implements Converter {

	private static final Logger LOG = Logger.getLogger(DateConverter.class);

	/**
	 * This method converts String value to java.util.date
	 * 
	 * @param type
	 * @param value
	 */
	@Override
	public Object convert(Class type, Object value) {

		Date date = null;
		try {
			String inputDate = value.toString();
			SimpleDateFormat formatter = new SimpleDateFormat(
					ProjectConstant.EN_DATE_PATTERN);
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			LOG.error(ProjectConstant.ERROR_CONVERT_DATE + e);
		}
		return date;
	}

}
