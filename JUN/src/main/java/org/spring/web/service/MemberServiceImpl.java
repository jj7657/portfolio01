package org.spring.web.service;
import org.spring.web.mapper.MemberMapper;
import org.spring.web.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public void createMember(MemberVO vo) throws Exception {
		mapper.createMember(vo);
	}

	@Override
	public MemberVO memberRead(MemberVO vo) throws Exception {
		return mapper.memberRead(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		mapper.updateMember(vo);	
	}

	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		mapper.deleteMember(vo);	
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return mapper.login(vo);
	}

	@Override
	public String idCheck(MemberVO vo) throws Exception {
		return mapper.idCheck(vo);
	}
	
	
}
