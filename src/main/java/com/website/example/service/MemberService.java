package com.website.example.service;

import javax.servlet.http.HttpServletRequest;
import com.website.example.vo.MemberVO;

public interface MemberService {

	// AOP 사용할 때, boolean 사용하면 안 됨
	public int authorize(HttpServletRequest req, MemberVO vo, String token);
	
}
