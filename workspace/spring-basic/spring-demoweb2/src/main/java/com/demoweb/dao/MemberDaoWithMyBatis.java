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
		
		Member member2 = 
			sqlSessionTemplate.selectOne(MEMBER_MAPPER + ".selectMemberByIdAndPasswd", member);
		return member2;
		
	}
	
	
}
