package com.itwillbs.domain;

public class PageMaker {

	// 페이징 처리에 관련된 동작 수행
	
	private Criteria cri; // 페이지에 출력되는 게시판 글의 개수 페이징처리
	
	// 페이지 하단부에 처리되는 페이징 처리
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10; //페이지 블럭
	
	
	public void setCri(Criteria cri) {
		  this.cri = cri;
	}
	
	// 총 개수 계산
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		// 페이징에 필요한 정보처리 
		CalcData();
	}
	
	public void CalcData() {
		System.out.println(" -----  페이징 처리에 필요한 정보 계산 -----");
		endPage = (int)Math.ceil(cri.getPageStart()/(double)displayPageNum) * displayPageNum;
		
		startPage = (endPage - displayPageNum)+1;
		
		int tmpEndPage = (int) Math.ceil(totalCount/(double)cri.getPageSize());
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		prev = (startPage == 1? false : true);
		
		next = endPage * cri.getPageSize() >= totalCount? false : true;
		System.out.println(" -----  페이징 처리에 필요한 정보 계산 -----");
	}

	// get/set
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public int getTotalCount() {
		return totalCount;
	}

	
	
	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + "]";
	}
	
	
	
	
	
	
	
}
