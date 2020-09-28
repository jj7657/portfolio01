package org.spring.web.mapper;

import org.spring.web.vo.MemberVO;

public interface MemberMapper {
	
	public void createMember(MemberVO vo) throws Exception;
	
	public MemberVO memberRead(MemberVO vo)throws Exception;

	public void updateMember(MemberVO vo)throws Exception;
	
	public void deleteMember(MemberVO vo)throws Exception;
	
	public MemberVO login(MemberVO vo)throws Exception;

	public String idCheck(MemberVO vo) throws Exception;
}
