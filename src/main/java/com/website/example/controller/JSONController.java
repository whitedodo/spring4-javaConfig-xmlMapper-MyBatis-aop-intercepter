package com.website.example.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/json")
public class JSONController {

	private static final Logger logger = LoggerFactory.getLogger(JSONController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public ModelAndView write(HttpServletRequest req, 
							  HttpServletResponse res) {
		
		logger.info("Welcome JSON! The client locale is {}.");
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		
		ModelAndView mav = new ModelAndView();
		
        JSONObject obj = new JSONObject();
        obj.put("name", "홍길동");
        obj.put("age", 2020);
 
        JSONArray list = new JSONArray();
        list.add("messages01");
        list.add("messages02");
        list.add("messages03");
 
        obj.put("messages", list);
 
        try (FileWriter file = new FileWriter("c:\\temp\\Data.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        mav.addObject("result", obj.toJSONString());
		mav.setViewName("json/write");
		
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public ModelAndView read(HttpServletRequest req, 
							  HttpServletResponse res) {
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		
		ModelAndView mav = new ModelAndView();
		
		JSONParser parser = new JSONParser();
		 
        try (Reader reader = new FileReader("c:\\temp\\Data.json")) {
 
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
 
            String name = (String) jsonObject.get("name");
            System.out.println(name);
 
            long age = (Long) jsonObject.get("age");
            System.out.println(age);
 
            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

		mav.setViewName("json/read");
		
		return mav;
	}
	
}
