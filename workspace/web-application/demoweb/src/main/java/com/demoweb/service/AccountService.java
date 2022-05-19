package com.demoweb.service;

import com.demoweb.dao.MemberDao;
import com.demoweb.dto.Member;

public class AccountService {
	
	public void registerMember(Member member) {
		
		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

}
