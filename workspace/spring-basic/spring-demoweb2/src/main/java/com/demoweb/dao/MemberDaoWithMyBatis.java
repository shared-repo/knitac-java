package com.demoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demoweb.dto.Member;

import lombok.Setter;

public class MemberDaoWithMyBatis implements MemberDao {
	
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Setter
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String MEMBER_MAPPER = "com.demoweb.mapper.MemberMapper";
	
	@Override
	public void insertMember(Member member) {		
		// sqlSessionTemplate.insert("com.demoweb.mapper.MemberMapper.insertMember", member);
		sqlSessionTemplate.insert(MEMBER_MAPPER + ".insertMember", member);
	}

	@Override
	public Member selectMemberByIdAndPasswd(Member member) {
		
		// 3. SQL 작성 + 명령 객체 만들기
		String sql = "select memberid, email, usertype, active, regdate " +
					 "from member " +
					 "where memberid = ? and passwd = ? and active = true";		
		Member member3 = jdbcTemplate.queryForObject(
				sql,
				// RowMapper를 구현한 익명 클래스 만들기 + 그 클래스의 인스턴스 만들
				new RowMapper<Member>() { // 행 처리기
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member2 = new Member();
						member2.setMemberId(rs.getString(1));
						member2.setEmail(rs.getString(2));
						member2.setUserType(rs.getString(3));
						member2.setActive(rs.getBoolean(4));
						member2.setRegDate(rs.getDate(5));
						return member2;
					}					
				},
				member.getMemberId(), member.getPasswd()
		);
		return member3;
	}
	
	
}
