package com.demoweb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// DTO 클래스 : 데이터 전달을 위한 클래스, 대상 테이블(member table) 에 일치하도록 구현
public class Member implements Serializable {
	
	// 필드는 대상 테이블의 컬럼을 기준으로 작성
	// @NotBlank(message = "아이디를 입력하세요")
	@NotBlank(message = "{memberId.required}")
	//@Length(min=8, max=20, message = "아이디는 8~20문자 범위입니다.")
	@Pattern(regexp = "[A-Za-z0-9]{8,20}", message = "아이디는 8~20개의 영문자/숫자 조합입니다.")
	private String memberId;
	
	@NotBlank(message = "패스워드를 입력하세요")
	@Pattern(regexp = "[A-Za-z0-9@#$]{8,20}", message = "패스워드 형식 오류")
	private String passwd;
	
	@NotBlank(message = "이메일을 입력하세요")
	@Email(message = "이메일 형식이 아닙니다")
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
