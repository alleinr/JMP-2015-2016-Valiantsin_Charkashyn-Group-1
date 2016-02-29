package com.epam.testapp.presentation.form;

import java.util.List;

/**
 * This class is a form for Struts action. This form contains single news, 
 * list of all news and array-helper for keeping 
 * ids of items that should be removed.
 */




import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.epam.testapp.model.News;

public class NewsForm extends ActionForm {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private News newsMessage;
	private List<News> newsList;
	private Integer[] selectedItems;

	public Integer[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(Integer[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public NewsForm() {
		selectedItems = null;
	}

	public News getNewsMessage() {
		return newsMessage;
	}

	public void setNewsMessage(News newsMessage) {
		this.newsMessage = newsMessage;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;

	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (getNewsList() == null || getNewsList().isEmpty()) {
			errors.add("error.newslistempty", new ActionMessage(
					"error.message.newslistempty"));
		}
		return errors;
	}

}
