package com.website.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.website.example.vo.BoardVO;
import com.website.example.vo.MemberVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    private static final String Namespace = "com.website.example.mapper.BoardMapper";
    
	public BoardVO selectBoard(String boardname, long id) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardname", boardname);
		paramMap.put("id", id);
		
		return sqlSession.selectOne(Namespace + ".selectBoard", paramMap);
		
	}

	@Override
	public void createMember(MemberVO vo) {

		sqlSession.insert(Namespace + ".insertMember", vo);
		
	}

}
