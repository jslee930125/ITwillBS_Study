package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {

	// 글쓰기 동작
	public void regist(BoardVO vo) throws Exception;
	
	// 글목록 전체 조회
	public List<BoardVO> listALL() throws Exception;
	
	// 특정 글 정보를 조회
	public BoardVO read(int bno) throws Exception;
	
	// 글 정보 수정 (제목,이름,내용)
	public void modify(BoardVO VO) throws Exception;
	
	// 글 정보 삭제 
	public void remove(Integer bno) throws Exception;
	
	
	// 글 목록조회 (Cri)
	public List<BoardVO> listCri(Criteria cri) throws Exception;
	
	
}
