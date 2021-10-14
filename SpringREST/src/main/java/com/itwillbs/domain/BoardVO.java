package com.itwillbs.domain;

public class BoardVO {
	
	private int bno;
	private String writer;
	private String title;
	private String contents;
	
	// json은 date 타입을 인식 못하니까 string으로 잡는다. 디비에서는 date타입이고 꺼낼 때는 string으로 바꾼다.
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}
	
	

}
