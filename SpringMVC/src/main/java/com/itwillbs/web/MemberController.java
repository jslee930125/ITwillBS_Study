package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

//@RequestMapping("/member/*") : /member/~ 모든 주소에 접근을 제어한다. 컨트롤러에도 적용가능한 애너테이션

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);
	
	// memberdao를 직접적으로 불러올 수 없으니까
	// 서비스 객체를 주입
	// 컨트롤러는 서버를 통해서만 실행가능
	
	@Inject
	private MemberService service;
	
	// http://localhost:8080/web/member/join
	// 회원가입
	// 1) 사용자 정보 입력
	@RequestMapping("/join")
	public void MemberJoinGET() throws Exception {
		logger.info(" 컨트롤러 실행-MemberJoinGET()" );
		logger.info(" view 페이지로 이동 후 정보입력");
		// 컨트롤러 >> 멤버조인 겟 >> 조인.jsp >> 회원정보 입력 >> 서브밋 >> /web/joins
		// http://localhost:8080/web/join?userid=dddd&userpw=ddd&username=dddd&useremail=dddd
	}
	
	// 2) 사용자 정보 처리
	@RequestMapping("/joinAction")
	public void MemberJoinPOST(MemberVO vo) throws Exception {
		
		logger.info("jsp 페이지에서 정보를 받아서");
		logger.info("MemberJoinPOST() 메서드 호출");
		
		// action = new MemberJoinAction(): (x) - 서비스가 하는 일, 여기서는 하지 않음
		
		// 전달받은 정보 저장 - request 내장객체 없음
		// MemberVO 하나가 request 받아올 것을 다 받아옴, 
		// submit 하는 순간 MemberVO에 알아서 들어감, 단 파라미터명이 멤버 도메인과 같은 경우에만 가능
		// <jsp:usebean>에서 파라미터 안적어도 알아서 매칭하는 것과 같음
		
		// 전달받은 정보 저장
		System.out.println(vo);
		
		// 회원가입 처리하는 동작을 호출
		// 서비스 - dao - mapper 가 다 연결됨
		service.memberJoin(vo);	
	}
	
	// Spring 방식 - 회원가입
	// http://localhost:8088/web/member/joins
	
	@RequestMapping(value = "/joins", method = RequestMethod.GET)
	public String MemberJoinGETs() throws Exception {
		// get방식 : 정보입력페이지, get방식이라서 405에러 발생
		logger.info("MemberJoinGETs() 호출!!!");
		logger.info("join.jsp페이지 이동");
		
		return "/member/join";
		
	}
	
	// 동일한 주소를 방식만으로 구분해서 처리
	
	@RequestMapping(value = "/joins", method = RequestMethod.POST)
	public String MemberJoinPOSTs(MemberVO vo) throws Exception {
		// post방식 : 정보입력페이지 - 정보 전달 역할
		logger.info("MemberJoinPOSTs() 호출!!!");
		System.out.println("전달된 파라미터 값(vo): " +vo);
		
		service.memberJoin(vo);
		
		logger.info("회원가입 성공");
		logger.info("페이지 이동");
		
		// return "/member/login"; - joins일때 찾아가는 주소임, 주소는 join 화면은 로그인페이지로 감
		return "redirect:/member/login";
		// redirect 해줘야 해당에 맞는 페이지로 찾아감
		
	}
	
	// 로그인 동작 
	//  view -> 컨트롤러(post) - > 전달정보확인(id,pw) -> 서비스 -> dao -> mapper.xml -> mysql -> 역순
    // => 로그인 성공시 메인페이지 
    // 1) 사용자가 아이디 패스워드 입력하는 페이지 호출
	// 1) 사용자가 id/pw를 입력하는 페이지 호출
	
	// http://localhost:8080/web/member/login
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String MemberLoginGET() throws Exception {
		logger.info("MemberLoginGET() 호출!!!!! ");
		
		return "/member/loginForm";
	}
	
	// 2) 뷰페이지에서 입력받은 정보를 처리 (DB)
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String MemberLoginPOST(MemberVO vo, HttpSession session) throws Exception {
               // MemberLoginPOST(@ModelAttribute("vo") MemberVO vo)와 같음
		       // form태그로 넘긴 데이터는 객체로 받아오면 알아서 매핑된다.
		       // jsp 페이지에서 넘어오므로 session정보도 넘어온다
		
		logger.info("로그인 체크동작 수행 ");
		logger.info("MemberLoginPOST() 호출!!!!! ");
		// 전달되는 로그인정보를 저장 (form-userid,userpw)
		// 내장객체가 없기 때문에 request를 사용할 수 없다.
		// System.out.println(vo); vo: 폼태그에서 입력한 데이터들
		
		// 서비스동작을 호출 -> DAO -> 디비 접근
		MemberVO loginResultVO = service.loginCheck(vo);
		logger.info(""+loginResultVO);
		
		// 로그인 여부에 따라 처리
		// 로그인x
			//=> 페이지에 머무르기 => 로그인 페이지 이동 (화면전환이 필요함-redirect)
		if(loginResultVO == null) {
			return "redirect:/member/login";
		}
		
		// 로그인
			//=> 세션정보(id)를 저장, 메인페이지 이동
		session.setAttribute("userid", loginResultVO.getUserid());
		
		logger.info("/member/main 페이지(view) 이동");
		
		// /member/main 페이지 이동
		return "redirect:/member/main";
	}
	
	
	// main페이지 처리 (get-/member/main)
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public void mainGet() throws Exception {
		logger.info(" mainGet() 호출!!! ");
		logger.info("views/member/main.jsp 페이지로 이동");
	}
	
	// 로그아웃 처리 (get - /member/logout)
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		// 세션정보를 받아와야함 (main.jsp)
		logger.info(" logoutGET() 호출!!! ");
		
		// 로그아웃 처리 - 세션값을 초기화
		session.invalidate();
		// 굳이 서비스계층까지 갈 필요 없다. 여기서 세션제어
		
		// return "./main"; 
		// 페이지를 보여주겠다는 의미가 됨.
		// 페이지 이동 (main 페이지)
		
		return "redirect:/member/main";
		// 페이지로 이동하겠다는 의미.
		// redirect: = URL : http://localhost:8080/web/ 의 의미와 같다.		
	}
	
	// http://localhost:8080/web/member/login

	// 회원정보조회 (get-/member/info)
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String memberInfoGET(HttpSession session, Model model) throws Exception {
		logger.info(" memberInfoGET() 호출!!! ");
		
		//세션값 저장
		String id = (String) session.getAttribute("userid");
		// 없을경우 페이지 이동 (redirect) - 생략
		
		// 서비스 계층 - getMember(id) / MemberVO 리턴;
		MemberVO vo = service.getMember(id);
		logger.info("@@"+vo + "\n\n");
		
		// 모델 객체에 저장 - view 페이지까지 전달
		model.addAttribute("vo",vo);
		
		// 페이지 이동 /member/info.jsp
		return "/member/info";
		
	}
	
	// 회원정보 수정
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void memberUpdateGET(HttpSession session,Model model) throws Exception {
		logger.info(" memberUpdateGET() 호출 ");
		
		// 세션값(id) 가져오기
		String id = (String) session.getAttribute("userid");
		
		// 기존의 회원정보를 가져오기
		// MemberVO vo = service.getMember(id);
		// view 페이지에 출력 (전달)
		// model.addAttribute("vo", vo);
		
		// 위의 2단계를 보통은 이렇게 다이렉트로 넘긴다.
		model.addAttribute("vo", service.getMember(id));
		
		
		logger.info("/member/udpate.jsp 페이지로 이동");
		
	}
	
	// 회원정보 수정 처리
	@RequestMapping(value="/update",method= RequestMethod.POST)
	public String memberUpdatePOST(MemberVO uvo) throws Exception{
		
		logger.info(" memberUpdatePOST() 호출 ");
		
		// 전달된 정보 저장(수정할 데이터)
		logger.info("수정할 정보:"+uvo);
		
		// 미리 updatedate를 설정하고 디비단에서 설정 안하려면 이렇게 진행
		//uvo.setUpdatedate(new Timestamp(System.currentTimeMillis()));
		//logger.info("수정할 정보:"+uvo);
		
		// 서비스를 사용하여 회원정보 수정
		int result = service.updateMember(uvo);
		
		logger.info("회원 정보 수정 결과 : " + result);
		// 페이지 이동 
		logger.info(" main 페이지로 이동 (화면전환)");
				
		return "redirect:./main";
		
	}
	
	// 회원탈퇴(GET)
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public void memberDeleteGET(HttpSession session, Model model) throws Exception {
		
		logger.info(" memberDeleteGET() 호출 ");
		
		// 세션정보(id) 가져오기
		String id = (String) session.getAttribute("userid");
		
		model.addAttribute("vo", service.getMember(id));
		
		logger.info("/member/delete.jsp 페이지로 이동");
		
	}
	
	
	// 회원탈퇴(POST)
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	public String memberDeletePOST(MemberVO dvo, HttpSession session) throws Exception{
		logger.info(" memberDeletePOST() 호출 ");
		
		// 세션정보
		String id =(String) session.getAttribute("userid");
		dvo.setUserid(id);
		
		logger.info("삭제할 정보:"+dvo);
		
		// 서비스에 탈퇴 동작
	    service.deleteMember(dvo);
	    
	    // 로그인정보(세션값)
	    session.invalidate();
		
		logger.info(" /member/main.jsp 페이지로 이동 (화면전환)");
		return "redirect:./main";
		
	}
	
	// 회원목록 리스트(관리자 기능)
	// ./list - GET
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String memberListGET(HttpSession session, Model model) throws Exception {
		
		logger.info("memberListGET() 호출");
		
		String id = (String) session.getAttribute("userid");
		
		if(id == null || !id.equals("admin")) {
			//RedirectAttributes로 정보 가지고 넘어갈 수 있다
			return "redirect:/member/main";
		}
		
		// 서비스 동작 호출
		List<MemberVO> memberList = service.getMemberList(id);
		
		model.addAttribute("mList", memberList);
		
		// 페이지 이동 : member/list.jsp 페이지
		
		return "/member/list";

	}
	
	
	

}
