package com.website.example.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Repository;
import com.website.example.vo.MemberVO;

@Repository("memberService")
public class MemberServiceImpl implements MemberService {

	// AOP 사용할 때, boolean 사용하면 안 됨
	public int authorize(HttpServletRequest req, MemberVO vo, String token) {
		
		System.out.println("핵심");
		return 0;
	}
	
}
