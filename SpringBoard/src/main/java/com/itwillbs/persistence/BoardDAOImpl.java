package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

// @Repository : 해당 클래스가 DAO객체의 역활을 하도록 등록(root-context.xml)

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	// 디비연결처리 (의존주입)
	//@Inject
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger  
	    = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// Mapper 파일을 구분하기위한 사용자 지정 고유값
	private static final String namespace = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		logger.info(" create(BoardVO vo)  호출! ");
		logger.info(" mapper이동후 해당 SQL 구문을 실행 ! ");
		
		// mapper - create 구문 호출
		int result = sqlSession.insert(namespace+".create",vo);
		
		logger.info(" 생성 구문 : "+result+" 개");
		logger.info(" DAO 동작 처리 완료 (글쓰기 완료) ");
	}

	
	@Override
	public BoardVO read(int bno) throws Exception {
		logger.info(" read(bno) 호출 - mapper이동 해당 sql 실행 ");
		// "com.itwillbs.mapper.BoardMapper.read"
		BoardVO vo = sqlSession.selectOne(namespace+".read",bno);
		
		//logger.info(vo+"");
		
		return vo;
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		logger.info("update(vo) 호출 ");
		
		//mapper에 있는 sql 호출
	    int result = sqlSession.update(namespace+".update",vo);
		
		logger.info("글 정보 수정완료! "+ result);		
		
	}


	@Override
	public void delete(Integer bno) throws Exception {
		
		logger.info("delete(bno) 호출");
		
		int result = sqlSession.delete(namespace+".delete",bno);
		
		logger.info(" 게시판 글 삭제 성공! "+result);		
		
	}

	
	@Override
	public List<BoardVO> listALL() throws Exception {

		System.out.println(" DAO : listALL() -> mapper 호출");
		
		System.out.println(" DAP : mapper-sql구문 실행완료! 서비스로 정보 전달!!");

		//List<BoardVO> boardList = sqlSession.selectList(namespace+".listALL");
		//return boardList;
		
		return sqlSession.selectList(namespace+".listALL");
	}


	@Override
	public void modify(BoardVO vo) throws Exception {
		logger.info("modify(BoardVO vo) 호출 - 정보수정 ");
		
		sqlSession.update(namespace+".modify", vo);
		
		logger.info(" 정보 수정 완료!  서비스로 전달 ");
	}


	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		logger.info(" listPage(int page) 호출! ");
		
		// page정보가 음수가 들어왔을경우 항상 1페이지 
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		// mapper에 동작호출
		
		return sqlSession.selectList(namespace+".listPage",page);
	}

	

	@Override
	public List<BoardVO> listCri(Criteria cri) throws Exception {
		logger.info("listCri(Criteria cri) 호출 !");
		
		return sqlSession.selectList(namespace+".listCri",cri);
	}
	
	
	
	
	

	
	
	
	

}
