package com.epam.testapp.presentation.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.testapp.exception.NewsServiceException;
import com.epam.testapp.model.News;
import com.epam.testapp.presentation.form.NewsForm;
import com.epam.testapp.service.INewsService;
import com.epam.testapp.util.ProjectConstant;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class contains actions for forwarding or redirecting data.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class NewsAction extends DispatchAction {

	private static final Logger LOG = Logger.getLogger(NewsAction.class);
	private INewsService newsService;

	/**
	 * Default constructor which defines ApplicationContext and value of
	 * newsService bean.
	 */
	public NewsAction() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		newsService = (INewsService) context.getBean("newsService");
	}

	/**
	 * Action that gets all news items and forwards to main news page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		List<News> allNews;
		try {
			allNews = newsService.getList();
			newsForm.setNewsList(allNews);
			saveErrors(request, newsForm.validate(mapping, request));
			request.getSession().setAttribute(ProjectConstant.PARAM_FROM,
					ProjectConstant.PAGE_LIST);
			return mapping.findForward(ProjectConstant.PAGE_LIST);
		} catch (NewsServiceException e) {
			LOG.error(ProjectConstant.ERROR_GET_LIST, e);
			return mapping.findForward(ProjectConstant.PAGE_ERROR);
		}
	}

	/**
	 * Action that forwards to add page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		News news = new News();
		news.setPostDate(new Date(System.currentTimeMillis()));
		newsForm.setNewsMessage(news);
		request.getSession().setAttribute(ProjectConstant.PARAM_FROM,
				ProjectConstant.PAGE_LIST);
		return mapping.findForward(ProjectConstant.PAGE_EDIT);
	}

	/**
	 * Action that opens an edit page of existing item.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		News news;
		Integer id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else if (newsForm.getNewsMessage().getId() != 0) {
			id = newsForm.getNewsMessage().getId();
		}
		try {
			news = newsService.fetchById(id);
			newsForm.setNewsMessage(news);
			return mapping.findForward(ProjectConstant.PAGE_EDIT);
		} catch (NewsServiceException e) {
			LOG.error(ProjectConstant.ERROR_FETCH_ID, e);
			return mapping.findForward(ProjectConstant.PAGE_ERROR);
		}
	}

	/**
	 * Action that saves existing item or creates new news.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		News news = newsForm.getNewsMessage();
		try {
			Integer id = newsService.save(newsForm.getNewsMessage());
			news.setId(id);
			return mapping.findForward(ProjectConstant.PAGE_SAVED);
		} catch (NewsServiceException e) {
			LOG.error(ProjectConstant.ERROR_SAVE_ITEM, e);
			return mapping.findForward(ProjectConstant.PAGE_ERROR);
		}
	}

	/**
	 * An action that deletes existing item and forwards to main page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		Integer[] items = newsForm.getSelectedItems();
		try {
			newsService.remove(items);
			return mapping.findForward(ProjectConstant.PAGE_SUCCESS);
		} catch (NewsServiceException e) {
			LOG.error(ProjectConstant.ERROR_REMOVE_ITEM, e);
			return mapping.findForward(ProjectConstant.PAGE_ERROR);
		}
	}

	/**
	 * An action that cancels from edit/add page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */

	public ActionForward cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String page = (String) request.getSession().getAttribute(
				ProjectConstant.PARAM_FROM);
		NewsForm newsForm = (NewsForm) form;
		saveErrors(request, newsForm.validate(mapping, request));
		return mapping.findForward(page);

	}

	/**
	 * An action that provides view of existing news.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object that contains name of page to which should
	 *         be made forward.
	 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		int newsId;
		String newsIdParam = request.getParameter("id");
		if (newsIdParam != null) {
			newsId = Integer.parseInt(newsIdParam);
		} else {
			newsId = newsForm.getNewsMessage().getId();
		}
		try {
			News news = newsService.fetchById(newsId);
			newsForm.setNewsMessage(news);
			request.getSession().setAttribute(ProjectConstant.PARAM_FROM,
					ProjectConstant.PAGE_VIEW);
			return mapping.findForward(ProjectConstant.PAGE_VIEW);
		} catch (NewsServiceException e) {
			LOG.error(ProjectConstant.ERROR_FETCH_ID, e);
			return mapping.findForward(ProjectConstant.PAGE_ERROR);
		}

	}
}
