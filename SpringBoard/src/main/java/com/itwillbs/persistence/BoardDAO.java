package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardDAO {
	// 게시판에 동작하는 구문을 미리설계
	
	// 게시판 글쓰기 
	public void create(BoardVO vo) throws Exception;
	
	// 게시판 조회 (특정 글)
	public BoardVO read(int bno) throws Exception;
	
	// 게시판 글 수정(제목,내용)
	public void update(BoardVO vo) throws Exception;
	
	// 게시판 글 삭제
	public void delete(Integer bno) throws Exception;
	
	// 게시판 글 전체 목록
	public List<BoardVO> listALL() throws Exception;
	
	// 게시판 글 수정(제목,이름,내용)
	public void modify(BoardVO vo) throws Exception;
	
	// 게시판 글 목록(페이징처리) - 특정페이지의 해당하는 글 10개씩 
	public List<BoardVO> listPage(int page) throws Exception;
	
	
	// 게시판 글 목록(페이징처리) - 특정페이지의 해당하는 글 원하는 만큼씩 
	//public List<BoardVO> listCri(int pageStart,int pageSize) throws Exception;
	public List<BoardVO> listCri(Criteria cri) throws Exception;
	

}
