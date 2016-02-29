package com.epam.testapp.presentation.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.actions.DispatchAction;

import com.epam.testapp.util.ProjectConstant;

/**
 * This class is an action class for selecting language on client side. Class
 * extends Struts 1's DispatchAction class for being able to do redirect to the
 * page from which was made language changing. Class contains only one method.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class LanguageSelectAction extends DispatchAction {

	/**
	 * This method change session's locale basing on user's choice.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return page to which should be made redirect.
	 */
	public ActionForward language(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String page = request.getHeader(ProjectConstant.PARAM_REF);
		String locale = request.getParameter("baseLocale");
		if (locale != null) {
			if (locale.equals("ru")) {
				request.getSession().setAttribute(Globals.LOCALE_KEY,
						ProjectConstant.RU_LOCALE);
			} else {
				request.getSession().setAttribute(Globals.LOCALE_KEY,
						Locale.ENGLISH);
			}
		}
		return new ActionRedirect(page);
	}

}
