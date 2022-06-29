package com.demoweb.service;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.dao.MemberDaoWithDataSource;
import com.demoweb.dto.Member;
import com.demoweb.mapper.MemberMapper;

import lombok.Setter;

public class AccountServiceImpl implements AccountService {
	
	@Setter // 자동으로 setMemberDao 메서드 생성 --> 의존 객체 주입 통로
	private MemberDao memberDao;
	
	@Setter
	private MemberMapper memberMapper; // Spring Mybatis가 자동으로 생성한 DAO

	@Override
	public void registerMember(Member member) {		
		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256"); // 암호화
		member.setPasswd(passwd);
		
		//memberDao.insertMember(member);
		memberMapper.insertMember(member);		
	}
	@Override
	public Member findMemberByIdAndPasswd(Member member) {		
		String passwd = member.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256"); // 암호화
		member.setPasswd(passwd);
		
		// Member member2 = memberDao.selectMemberByIdAndPasswd(member);
		Member member2 = memberMapper.selectMemberByIdAndPasswd(member);
		
		return member2;
	}

}
