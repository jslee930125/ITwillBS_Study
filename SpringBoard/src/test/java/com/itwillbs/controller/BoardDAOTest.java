package com.itwillbs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {

	
	// DAO 객체 생성 (의존 주입)
	@Inject
	private BoardDAO bdao;	
	
	// 로그
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	
	//@Test
	public void daoTest() throws Exception{
		logger.info(" 로그시작 \n");
		logger.info(bdao+"\n");
		logger.info(" 로그끝 \n");
	}
	
	// 게시판 글쓰기 테스트
	//@Test
	public void createTest() throws Exception{
		logger.info(" 게시판 글쓰기 시작");
		
		BoardVO inputVO = new BoardVO();
		
		inputVO.setTitle("2번 글테스트");
		inputVO.setContent("내용122222");
		inputVO.setWriter("관리자2");
		
		//DAO동작 호출
		bdao.create(inputVO);		
		
		logger.info(" 게시판 글쓰기 끝");
		
	}
	
	// 특정 글번호에 해당하는 글의 모든정보를 출력
	//@Test
	public void readTest() throws Exception{
		// 디비연결 - 의존주입
		logger.info(" readTest() 호출 ");
		
		BoardVO vo = bdao.read(1);
		
		logger.info(vo+"");		
		
	}
	
	// 게시판 정보 수정(특정글)
	//@Test
	public void updateTest() throws Exception{
		logger.info("글정보 수정!");
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(1);
		vo.setTitle("수정 제목");
		vo.setContent("수정 본문");
		
		bdao.update(vo);
		
		logger.info("수정결과 : "+ bdao.read(vo.getBno()));
	}
	
	
	// 게시판 글 삭제(특정글)
	//@Test
	public void deleteTest() throws Exception {
		
		logger.info("게시판 글 삭제!");
		
		bdao.delete(1);
		
	}
	
	
	//  페이징 처리된 리스트확인
	//@Test
	public void testListPage() throws Exception{
		// 5페이지에 있는 정보를 확인
		int page = 1;
		
		List<BoardVO> boardList = bdao.listPage(page);
		
		for(BoardVO vo :boardList) {
			logger.info(vo.getBno()+" : "+vo.getTitle());
		}
	}
	
	// Cri 객체를 사용한 페이징 처리
	@Test
	public void testListCri() throws Exception{
		// 페이지 처리정보
		Criteria cri = new Criteria(); // 1페이지 10개씩
		cri.setPageStart(5);
		cri.setPageSize(30);
		
		for(BoardVO vo : bdao.listCri(cri)) {
			logger.info(vo.getBno()+" ::: "+vo.getTitle());
		}
	}
	
	
	
	
	
	
}
