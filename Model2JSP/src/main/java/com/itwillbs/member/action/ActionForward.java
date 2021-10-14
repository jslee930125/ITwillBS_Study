package com.itwillbs.member.action;

public class ActionForward {
	// 페이지 이동정보를 저장하는 객체
	// 이동할 페이지 주소, 이동할 방식
	
    private String path;
    private boolean isRedirect;
    // 1)redirect방식 - true
    // 2)forward방식 - false    
    
    
    //alt shift s + r
    
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
    
    
    
	
	

}
