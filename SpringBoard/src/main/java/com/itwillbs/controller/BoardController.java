package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageMaker;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	
	// http://localhost:8088/board/register
	// 글쓰기(GET)
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		
		logger.info("registerGET() 호출 -> view 페이지");		
		// /board/register.jsp 
	}
	
	// 글쓰기(POST)
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String registerPOST(BoardVO vo,RedirectAttributes rttr /*Model model*/) throws Exception{
		
		logger.info("registerPOST() 호출");
		
		// 글쓰기 처리 
		// 0) 한글처리 -> 생략(web.xml에 설정)
		// 1) 전달정보 저장
		logger.info(" 전달된 정보 저장 ---------------------------- ");
		logger.info(vo+"");
		
		// 2) 서비스 객체를 주입받아서 서비스 동작을 호출
		service.regist(vo);
		
		// 2-1) 정보를 저장 전달
		//model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		
		
		// 3) 페이지 이동
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	
	// http://localhost:8088/board/listAll
	// 게시판 글 전체 조회하는 동작
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listALLGET(Model model,@ModelAttribute("result") String result) throws Exception{
		logger.info("listALLGET() 호출 -> view 페이지 이동");
		
		// 글쓰기 페이지에서 전달한 정보를 저장후 출력
		logger.info(" 페이지 처리 결과 : "+result);
		
		
		//List<BoardVO> boardList = service.listALL();
		//model.addAttribute("boardList", boardList);
		
		// 서비스 동작 호출
		// DB에서 가져온 글 정보를 view 페이지로 전달
		model.addAttribute("boardList",service.listALL());
		//model.addAttribute("result", result);
	
		// 페이지 이동 /board/listAll.jsp	
	}
	
	// 게시판 글 읽기 (read)
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno,Model model /* @ModelAttribute("bno") int bno */) throws Exception{
		logger.info(" readGET() 호출! ");
		
		// @RequestParam("bno") int bno 
		// => request.getParameter("bno"); 동작과 유사함
		// 차이점은 문자열, 숫자,날짜 형태의 데이터를 처리가능(형변환가능)
		
		// 전달된 정보를 저장(bno)
		logger.info(" 전달된 정보(bno) : "+ bno);
		
		// 서비스객체 - 글번호에 해당하는 정보를 가져오는 동작
		BoardVO vo = service.read(bno);
		
		//logger.info(vo+"");
		
		// DB에서 가져온 데이터를 저장
		model.addAttribute("vo", vo);
		
		// view 페이지로 이동  /board/read.jsp (register.jsp페이지 참고)
		
	}
	
	
	// 게시판 글 수정(GET) - DB에서 가져온 정보를 화면에 출력
	//@GetMapping(value = "/modify")
	//@RequestMapping(value = "/modify",method = {RequestMethod.GET,RequestMethod.POST})
	@RequestMapping(value = "/modify",method = {RequestMethod.GET})
	public void modifyGET(/* @ModelAttribute("bno") */ int bno,Model model) throws Exception {
		logger.info("modifyGET() 호출");
		//전달된 정보 저장(bno)
		logger.info("수정할 글 번호 : "+bno);
		
		// 글번호에 해당하는 글정보를 가져와서
		// (서비스-read)
		// model 객체에 저장
		model.addAttribute("uvo", service.read(bno));
		
		// 페이지 이동 /board/modify.jsp (register.jsp 페이지 참고)	
	}
	
	
	// 게시판 글 수정처리( POST )
	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception{
		logger.info(" modifyPOST(BoardVO vo) 호출" );
		// 수정할 정보를 저장
		//logger.info(vo+"");
		
		// 서비스 -  정보 수정 동작 호출
		service.modify(vo);
		
		logger.info("서비스 처리(수정) 완료! 페이지 이동 ");
		
		return "redirect:/board/listAll";
	}
	
	// 게시판 글 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(Integer bno) throws Exception{
		
		// 전달되는 데이터 저장(bno)
		
		// 서비스 객체안에 삭제처리 동작
		service.remove(bno);
		
		// 리스트페이지로 이동
		
		return "redirect:/board/listAll";
	}
	
	
	// http://localhost:8088/board/listCri
	// http://localhost:8088/board/listCri?pageStart=5
	// http://localhost:8088/board/listCri?pageSize=30
	// http://localhost:8088/board/listCri?pageStart=5&pageSize=30
	// 페이징처리 완료 - 리스트 목록(Cri)
	@RequestMapping(value = "/listCri",method = RequestMethod.GET)
	public void listCri(Criteria cri,Model model) throws Exception{
		
		logger.info("listCri() 호출");
		// 페이징 처리에 필요한 정보를 받아오기
		logger.info("페이징 처리에 필요한 정보 : "+cri);
		
		// 서비스 객체에 해당 동작을 호출 - listCri()
		// DB에서 전달된 정보를 저장
		model.addAttribute("boardList", service.listCri(cri));
		
		// /board/listCri.jsp 페이지 이동
		
	}
	
	
	// http://localhost:8088/board/listPage
	@RequestMapping(value = "/listPage",method = RequestMethod.GET)
	public void listPageGET(Criteria cri,Model model) throws Exception{
		
		// Criteria 객체 정보 저장(pageStart/pageSize)
		model.addAttribute("boardList", service.listCri(cri));
		
		// 페이징처리 정보생성 (하단부)
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(150);
		
		model.addAttribute("pm", pm);
		
		// /board/listPage.jsp 페이지 이동
		
	}
	
	
	
	
	
	
	
}
