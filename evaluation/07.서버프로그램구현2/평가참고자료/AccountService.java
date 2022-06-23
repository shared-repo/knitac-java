package com.demoweb.service;

import com.demoweb.dto.Member;

public interface AccountService {

	void registerMember(Member member);

	Member findMemberByIdAndPasswd(Member member);

}