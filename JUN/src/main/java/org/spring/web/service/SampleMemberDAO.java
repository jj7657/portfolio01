package org.spring.web.service;

import org.spring.web.vo.SampleMemberVO;

public interface SampleMemberDAO {
	
	public void createMember(SampleMemberVO vo)throws Exception;
	
}
