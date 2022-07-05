package com.demoweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demoweb.dto.Member;

@Mapper // root-context.xml 파일의 Mapper Bean 등록과 같은 기능
public interface MemberMapper {

	@Insert("INSERT INTO member (memberid, passwd, email) " +
			"VALUES (#{memberId}, #{passwd}, #{email})")
	void insertMember(Member member);
	
	@Select("SELECT memberid, email, usertype, active, regdate " +
			"FROM member " +
			"WHERE memberid = #{memberId} AND passwd = #{passwd}")	
	Member selectMemberByIdAndPasswd(Member member);
	
}
