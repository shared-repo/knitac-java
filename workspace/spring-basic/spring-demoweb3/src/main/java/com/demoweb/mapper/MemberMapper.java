package com.demoweb.mapper;

import com.demoweb.dto.Member;

public interface MemberMapper {

	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(Member member);
	
}
