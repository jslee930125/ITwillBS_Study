package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// http://localhost:8088/home2
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public String home2() {
		logger.info("home2 호출");
		logger.info("JsonTest.jsp 페이지 호출");
		
		return "JsonTest";
	}
	
	
	// http://localhost:8088/home3
	@RequestMapping(value = "/home3", method = RequestMethod.GET)
	public String home3() {
		logger.info("home3 호출");
		logger.info("BoardTest.jsp 페이지 호출");
		
		return "BoardTest";
	}
	
	
	
	
}
