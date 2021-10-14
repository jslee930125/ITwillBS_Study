package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : DAO역할의 파일설정 ( 스프링에 해당 파일이 DAO라고 설정 )
// => root-context.xml에서 bean으로 인식

@Repository
public class MemberDAOImpl implements MemberDAO{
	// DAO 객체 역할
	
	// 디비연결 => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;
	
	// memberMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		
		// String result = sqlSession.selectOne("select now()"); - mapper가 쓰이지 않음
		String result = sqlSession.selectOne(namespace + ".getTime");
		// com.itwillbs.mapper.MemberMapper.getTime mapper에서 getTime 구문을 들고 옴
		
		return result;
	}

	@Override
	public void insertMember(MemberVO vo) {
		// 1.2.디비 연결 - sqlSession이 이미 해 놓음
		// 3. sql 구문(mappers) + pstmt
		// 4. sql 실행
		
		System.out.println("DAO : 테스트 파일에서 insertMember(vo) 호출!! ");
		System.out.println("DAO : insertMember(vo) 메서드 호출");
		System.out.println("DAO : memberMapper.xml 이동 해당 구문 수행");
		
		sqlSession.insert(namespace+".insertMember", vo);
		
		System.out.println(" DAO : memberMapper.xml-insertMember 구문 실행 완료!");
		System.out.println(" DAO : 회원가입 완료! ");
		System.out.println(" DAO : 테스트 파일로 이동 ");
	}

	@Override
	public MemberVO getMember(String userid) {
		System.out.println("DAO : 테스트에서 호출");
		System.out.println("DAO : memberMapper.xml 이동");
		
		// 디비연결 - 정보조회
		MemberVO vo = sqlSession.selectOne(namespace+".getMember", userid);
		
		System.out.println(" DAO : 처리된 결과를 리턴 받아서 사용 ");
		System.out.println(" DAO : 리턴 결과를 테스트 파일로 전달 ");
		
		return vo;
	}

	@Override
	public void updateMember(MemberVO updateVO) {
		
		sqlSession.update(namespace+".updateMember", updateVO);
		System.out.println("DAO : 정보 수정 완료");
		
	}

	@Override
	public void deleteMember(String userid, String userpw) {
		
		// 방법 1. 메서드를 MemberVO형태로 전달받기
		// 메서드 전달인자가 동일한 형태의 객체로 저장이 가능한 경우
		// membervo라는 같은 객체에 들어갈 수 있는 경우, 사실 여기서는 이방법을 써야 함
		
		// 방법 2. Map형태로 처리
		// => 메서드 전달인자가 동일한 형태의 객체로 저장이 불가능한 경우
		//    (반드시 2개 이상의 전달인자를 사용해야만 하는 경우)
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		System.out.println("--------------------------------------");
		System.out.println(paramMap);
		System.out.println("--------------------------------------");
		
		sqlSession.delete(namespace+".deleteMember", paramMap);
		System.out.println("DAO : 정보 삭제 완료");
		
	}

	@Override
	public MemberVO loginCK(MemberVO vo) {
		
		System.out.println(" DAO : loginCK(vo) 호출 ");
		
		// mapper접근을 통한 SQL 구문 실행: 1개의 데이터를 가져오니까 SelectOne
		MemberVO loginResultVO = sqlSession.selectOne(namespace+".login", vo);
		
		System.out.println("DAO :" +loginResultVO);

		System.out.println(" DAO : 로그인 체크 완료 ");
		
		return loginResultVO;
	}
	
	@Override
	public int modify(MemberVO uvo) {
		
		System.out.println("DAO : modify(uvo) 호출 ");
		System.out.println("DAO : mapper 이동후 해당 SQL 실행");
		
		int result = sqlSession.update(namespace+".modify", uvo);
		
		System.out.println("DAO : 서비스 updateMember(uvo) 이동");
		
		return result;
		
	}

	@Override
	public List getMemberList(String id) {
		System.out.println("DAO : getMemberList(id) 호출");
		
		List<MemberVO> memberList = sqlSession.selectList(namespace+".memberList", id);
		// 쿼리결과를 자동으로 list로 저장해주는 메서드
				
		System.out.println(" DAO : 데이터 전달 ");		

		return memberList;
	}
	

}