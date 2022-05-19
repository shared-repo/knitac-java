package com.demoweb.service;

import com.demoweb.dao.MemberDao;
import com.demoweb.dto.Member;

public class AccountService {
	
	MemberDao memberDao = new MemberDao();
	
	public void registerMember(Member member) {
	
		// MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

	public Member findMemberByIdAndPasswd(Member member) {
		
		// MemberDao memberDao = new MemberDao();
		Member member2 = memberDao.selectMemberByIdAndPasswd(member);
		
		return member2;
	}

}
