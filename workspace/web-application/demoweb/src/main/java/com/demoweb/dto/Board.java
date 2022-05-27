package com.demoweb.dto;

import java.util.Date;
import java.util.List;

// Board Table의 데이터를 저장하기 위한 클래스
public class Board { 

	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	
	// Board 테이블과 BoardAttach 테이블 사이의 1 : Many 관계를 구현한 필드
	private List<BoardAttach> files;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public List<BoardAttach> getFiles() {
		return files;
	}
	public void setFiles(List<BoardAttach> files) {
		this.files = files;
	}
	
	
	
	
}
