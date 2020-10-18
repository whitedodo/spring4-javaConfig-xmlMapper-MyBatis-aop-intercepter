package com.website.example.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.example.dao.BoardDAO;
import com.website.example.service.MemberService;
import com.website.example.vo.MemberVO;

@RequestMapping(value = "/tx")
@Controller
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource ds;

	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO boardDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Transactional
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("Welcome MyBatis Transaction Test! The client locale is .");
		
		// 태스트용
		MemberVO vo1 = new MemberVO();
		vo1.setUsername("야");
		vo1.setPasswd("12345");
		vo1.setRegidate(Date.valueOf("2010-02-03"));
		
		boardDao.createMember(vo1);
		boardDao.createMember(null);
		
		
		mav.addObject("contextPath", req.getContextPath());
		mav.setViewName("home");
		
		return mav;
	}
}
