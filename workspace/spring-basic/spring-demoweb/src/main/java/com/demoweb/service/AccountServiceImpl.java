package com.demoweb.service;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.dao.MemberDaoImpl;
import com.demoweb.dto.Member;

public class AccountServiceImpl implements AccountService {
	
	MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public void registerMember(Member member) {
		
		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256"); // 암호화
		member.setPasswd(passwd);
	
		// MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

	@Override
	public Member findMemberByIdAndPasswd(Member member) {
		
		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256"); // 암호화
		member.setPasswd(passwd);
		
		// MemberDao memberDao = new MemberDao();
		Member member2 = memberDao.selectMemberByIdAndPasswd(member);
		
		return member2;
	}

}
