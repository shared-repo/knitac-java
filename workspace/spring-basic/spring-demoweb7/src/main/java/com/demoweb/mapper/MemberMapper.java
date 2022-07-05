package com.demoweb.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demoweb.dto.Member;

@Mapper // root-context.xml 파일의 Mapper Bean 등록과 같은 기능
public interface MemberMapper {

	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(Member member);
	
}
