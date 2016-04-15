package com.epam.mvc.task01.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mvc.task01.services.model.WebObject;
import com.epam.mvc.task01.services.service.WebObjectService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ObjectController {

	private WebObjectService woService;

	public ObjectController() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-context.xml");
		woService = (WebObjectService) context.getBean("woService");
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<WebObject> woList = woService.getList();
		model.addAttribute("itemsList", woList);
		return "home";
	}

	@RequestMapping(value = { "/saveObject" }, method = RequestMethod.GET)
	public String save(@ModelAttribute WebObject webObject, Model model) {
		woService.save(webObject);
		return "home";
	}
}