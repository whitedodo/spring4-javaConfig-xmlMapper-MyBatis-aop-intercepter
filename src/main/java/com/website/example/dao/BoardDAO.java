package com.website.example.dao;

import org.apache.ibatis.annotations.Param;

import com.website.example.vo.BoardVO;
import com.website.example.vo.MemberVO;

public interface BoardDAO {

	// 게시판 상세 조회
	public BoardVO selectBoard(@Param("boardname")String boardname, 
							   @Param("id")long id);
	
	// 추가(임시)
	// 회원 추가 insert
	public void createMember(MemberVO vo);
	
}
