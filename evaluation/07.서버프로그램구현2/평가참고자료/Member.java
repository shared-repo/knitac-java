package com.demoweb.dto;

import java.io.Serializable;
import java.util.Date;

// DTO 클래스 : 데이터 전달을 위한 클래스, 대상 테이블(member table) 에 일치하도록 구현
public class Member implements Serializable {
	
	// 필드는 대상 테이블의 컬럼을 기준으로 작성
	private String memberId;
	private String passwd;
	private String email;
	private String userType;
	private boolean active;
	private Date regDate;
	
	public Member() {} // 전달인자 없는 생성자 메서드 (기본 생성자)
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
