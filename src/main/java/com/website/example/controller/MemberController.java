package com.website.example.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.example.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/member")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource ds;
	
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("Welcome Member! The client locale is .");
		
		mav.addObject("contextPath", req.getContextPath());
		mav.setViewName("/member/login");
		
		return mav;
	}

	@RequestMapping(value = "authorize", method = RequestMethod.POST)
	public ModelAndView authorize(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mav = new ModelAndView();
		
		logger.info("Welcome Member! The client locale is .");
		
		mav.addObject("contextPath", req.getContextPath());
		
		String username = null;
		String passwd = null;
		
		int result = 1;
		
		memberService.authorize(req, null, "야");
		
		if ( req.getParameter("username") != null ) {
			username = req.getParameter("username"); 
		}
		
		if ( req.getParameter("passwd") != null ) {
			passwd = req.getParameter("passwd"); 
		}
		
		// 인증확인
		if (username.equals("user") && 
			passwd.equals("passwd"))
		{

			HttpSession session = req.getSession(true);
			session.setAttribute("login", "hello");
			
			result = 0;
		}
		
		if ( result == 0 ) {
			mav.setViewName("redirect:/");
		}else {
			mav.setViewName("redirect:/member/login");
		}
		
		return mav;
		
	}
}
