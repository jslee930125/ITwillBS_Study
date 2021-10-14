package com.itwillbs.bean;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.codegen.VerificationTypeInfo;

@WebServlet("/test1.do")
public class ServletTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet() 호출");
        
        // request 영역에 데이터 저장
        request.setAttribute("name", "컴퓨터");
        
        // reqeust 영역에 객체 데이터 저장
        // MemberBean 객체의 생성 -> set2.jsp 출력
        MemberBean mb = new MemberBean();
        mb.setId("admin");
        mb.setPw("1234");
        mb.setName("홍길동");
        mb.setAge(20);
        
        // request 영역에 저장
        request.setAttribute("mb", mb);
        
        MemberBean kim = new MemberBean();
        kim.setId("itwill");
        kim.setPw("1q2w3e");
        kim.setAge(20);
        kim.setName("김학생");
        
        // request 영역에 저장
        request.setAttribute("MemberBean", kim);
        
        // 리스트(가변길이 배열)에  위 2개의 정보를 모두 저장해서 처리
        Vector<MemberBean> v = new Vector<MemberBean>();
        
        v.add(mb);
        v.add(kim);
        
        // request 영역에 저장
        request.setAttribute("memberList", v);
        
        
        
        // 페이지이동(forward)
        RequestDispatcher dis 
          = request.getRequestDispatcher("/core/set2.jsp");
        dis.forward(request, response);
		
	}
	
	
	
	

}
