package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// ./boards/all
	// 게시판 글 조회 (GET - /all)
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> boardList(){
		
		// 게시판 글 조회동작(서비스동작)
		logger.info("boardList() 호출 - 글 전체 조회");
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		for(int i=0 ; i<10 ; i++) {
			
			BoardVO vo = new BoardVO();
			vo.setBno(i);
			vo.setTitle("제목"+i);
			vo.setContents("내용"+i);
			vo.setWriter("작성자"+i);
			
			list.add(vo);
		}
		
		logger.info( " 서비스에서 글정보 전달 완료 ");
		
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	// 게시판 글쓰기(post)
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> insertBoard(@RequestBody BoardVO vo){
		
		logger.info("insertBoard() 호출 - 글 쓰기");
		
		// 글쓰기 처리 (서비스 호출)
		logger.info("글쓰기 정보 : " +vo);
		logger.info("서비스 글쓰기 동작 호출");
		
		return new ResponseEntity<String>("Success",HttpStatus.OK) ;
		
	}

	//http://localhost:8088/boards/100
	// 게시판 글 조회 (GET - /all)
	@RequestMapping(value="/{bno}", method=RequestMethod.GET)
	public ResponseEntity<BoardVO> getBoard(@PathVariable int bno){
		
		logger.info("getBoard() 호출 - 글 전체 조회");
		logger.info("bno : " + bno);
		logger.info(" 서비스 - getBoard(bno) 호출 ");
		
		BoardVO vo = new BoardVO();
		vo.setBno(bno);
		vo.setTitle("title"+bno);
		vo.setContents("content"+bno);
		vo.setWriter("writer"+bno);
		
		return new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
			
	}
	
	// 정보 수정
	@RequestMapping(value="/{bno}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateBoard(@PathVariable int bno, 
			@RequestBody BoardVO vo ){		
		
		logger.info("updateBoard() 호출");
		logger.info(bno + "번 글을 수정");
		logger.info("수정데이터" + vo);
		
		return new ResponseEntity<String>("UPDATE ok", HttpStatus.OK);
	}
	
}
