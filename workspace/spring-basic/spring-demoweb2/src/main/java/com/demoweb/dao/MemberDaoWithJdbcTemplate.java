package com.demoweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.dto.Member;

import lombok.Setter;

public class MemberDaoWithJdbcTemplate implements MemberDao {
	
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertMember(Member member) {
			
		String sql = "insert into member (memberid, passwd, email) " +
					 "values (?, ?, ?)";
		jdbcTemplate.update(sql, 
				member.getMemberId(), member.getPasswd(), member.getEmail());
	}

	@Override
	public Member selectMemberByIdAndPasswd(Member member) {
		
		// 3. SQL 작성 + 명령 객체 만들기
		String sql = "select memberid, email, usertype, active, regdate " +
					 "from member " +
					 "where memberid = ? and passwd = ? and active = true";
		
		return null;
	}

}
