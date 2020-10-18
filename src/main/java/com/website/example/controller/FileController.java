package com.website.example.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.website.example.dao.BoardDAO;
import com.website.example.service.MemberService;
import com.website.example.vo.MemberVO;

@RequestMapping(value = "/file")
@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	private final String UPLOAD_PATH = "c:" + File.separator + "temp" + File.separator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = new ModelAndView();		
		logger.info("Welcome FileUpload Test! The client locale is .");

		System.out.println(req.getContextPath());
		
		mav.addObject("contextPath", req.getContextPath());
		mav.setViewName("insert");
		
		return mav;
	}
	
	@RequestMapping(value = "write_ok", method = RequestMethod.POST)
	public ModelAndView write_ok(HttpServletRequest req, 
			  						 HttpServletResponse res,
			  						 @RequestParam("mediaFile") MultipartFile[] files) throws IOException{
		
		logger.info("Board:: MultipartFile - Write");
		ModelAndView mav = new ModelAndView();
		
		String pageUrl = req.getContextPath() + "/file";
		
		// Save mediaFile on system
		for (MultipartFile file : files) {
			
			if ( !file.isEmpty() ) {
				saveFile(file);
			}
		}

		mav.addObject("pageUrl", pageUrl);
		mav.addObject("contextPath", req.getContextPath());
		mav.setViewName("home");
		
		return mav;
	}
	

	
	private String saveFile(MultipartFile file) throws IOException{
		
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + file.getOriginalFilename();
	
	    logger.info("saveName: {}",saveName);

        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        long filesize = file.getSize();
	    
	    // 저장할 File 객체를 생성
	    File saveFile = new File(UPLOAD_PATH, saveName); // 저장할 폴더 이름, 저장할 파일 이름
	
	    try {
	        file.transferTo(saveFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	
	    return saveName;
	}
	
	
}
