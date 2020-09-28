package org.spring.web.service;

import org.spring.web.vo.MemberVO;

public interface MemberService {
	
	public void createMember(MemberVO vo) throws Exception;
	
	public MemberVO memberRead(MemberVO vo)throws Exception;

	public void updateMember(MemberVO vo)throws Exception;
	
	public void deleteMember(MemberVO vo)throws Exception;
	
	public MemberVO login(MemberVO vo)throws Exception;

	public String idCheck(MemberVO vo) throws Exception;
	
}
