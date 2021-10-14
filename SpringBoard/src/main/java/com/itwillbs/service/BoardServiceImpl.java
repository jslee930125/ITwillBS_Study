package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger logger =
			LoggerFactory.getLogger(BoardService.class);
	
	@Inject
	private BoardDAO bdao;
	
	// alt shift s + v
	@Override
	public void regist(BoardVO vo) throws Exception {
		
		logger.info(" regist(BoardVO vo) 호출 -> DAO : create(BoardVO vo) 호출");
		
		bdao.create(vo);
		
		logger.info(" 글쓰기 완료 -> 컨트롤러 페이지로 이동");		
		
	}

	@Override
	public List<BoardVO> listALL() throws Exception {
		
		System.out.println(" S : listALL() 호출 -> DAO-");
		
		System.out.println(" S : DAO 처리 완료! 정보 저장후 컨트롤러 이동");
		
		return bdao.listALL();
	}

	
	@Override
	public BoardVO read(int bno) throws Exception {
		
		System.out.println(" S : read(bno) 호출 -DAO:read(bno)");
		
		BoardVO vo = bdao.read(bno);
		
		//System.out.println(" S : "+vo);
		System.out.println(" S : DAO 처리후 컨트롤러로 이동");
		
		return vo;
	}

	@Override
	public void modify(BoardVO VO) throws Exception {
		logger.info(" modify(BoardVO VO) 호출 ");
		
		bdao.modify(VO);
		
		logger.info(" 정보수정 완료 -> 컨트롤러 이동 ");		
		
	}

	@Override
	public void remove(Integer bno) throws Exception {
		logger.info(" remove(Integer bno) 호출 ");
		
		bdao.delete(bno);
		
		logger.info(" 삭제 처리 완료! ");
		
	}

	@Override
	public List<BoardVO> listCri(Criteria cri) throws Exception {
		logger.info("listCri(Criteria cri) 호출! ");
		
		return  bdao.listCri(cri);
	}
	
	
	
	
	
	
	
	
	
	
	
}
