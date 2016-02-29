package com.epam.testapp.util;

import java.util.Locale;

public class ProjectConstant {
	public static final String PARAM_REF = "referer";
	public static final Locale RU_LOCALE = new Locale("ru");
	public static final String PARAM_FROM = "from";
	public static final String STRING_SPACE = "&nbsp;";
	public static final String REGEX_SPACE = "\\s";
	public static final String EN_DATE_PATTERN = "MM/dd/yyyy";
	
	public static final String PAGE_VIEW = "view";
	public static final String PAGE_LIST = "list";
	public static final String PAGE_SAVED = "saved";
	public static final String PAGE_EDIT = "edit";
	public static final String PAGE_SUCCESS = "success";
	public static final String PAGE_ERROR = "error";
	
	public static final String SQL_FIND_ALL_QUERY = "SELECT ID,TITLE,POSTDATE,BRIEF,CONTENT FROM NEWS ORDER BY POSTDATE DESC";
	public static final String SQL_FIND_BY_ID_QUERY = "SELECT ID,TITLE,POSTDATE,BRIEF,CONTENT FROM NEWS WHERE ID = ?";
	public static final String SQL_CREATE_NEWS_QUERY = "INSERT INTO NEWS (TITLE,POSTDATE,BRIEF,CONTENT) VALUES (?,?,?,?)";
	public static final String SQL_DELETE_NEWS_QUERY = "DELETE FROM NEWS WHERE ID = ?";
	public static final String SQL_UPDATE_NEWS_QUERY = "UPDATE NEWS SET TITLE = ?, POSTDATE = ?, BRIEF = ?, CONTENT = ? WHERE ID = ? ";
	
	public static final String JPQL_FIND_ALL_QUERY = "SELECT n FROM News n";
	public static final String NQL_REMOVE_QUERY = "delete from News n where n.id in (:ids)";
	
	public static final String SQL_ID_PARAM = "ID";
	public static final String SQL_TITLE_PARAM = "TITLE";
	public static final String SQL_POSTDATE_PARAM = "POSTDATE";
	public static final String SQL_BRIEF_PARAM = "BRIEF";
	public static final String SQL_CONTENT_PARAM = "CONTENT";
	
	public static final String ERROR_FETCH_ID = "Error occurred while fetching item with id = ";
	public static final String ERROR_SAVE_ITEM = "Error occurred while saving item with parameters " ;
	public static final String ERROR_GET_LIST = "Error occurred while downloading list ";
	public static final String ERROR_REMOVE_ITEM = "Error occurred while removing item from array by ";
	public static final String ERROR_CONVERT_DATE = "Error while converting date! Details: ";
	public static final String ERROR_NULL = "Was returned null from DAO, something happened!";
	public static final String INFO_INIT_FILTER_ENCODING = "Initializing filter with init parameter encoding = " ;
	public static final String INFO_REMOVE_ITEM = "Removing item with id ";
	public static final String ERROR_UPDATE_ITEM = "Error occurred while creating news";	
}
