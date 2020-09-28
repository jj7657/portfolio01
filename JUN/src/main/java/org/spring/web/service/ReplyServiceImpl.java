package org.spring.web.service;

import java.util.List;

import org.spring.web.mapper.ReplyMapper;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.PageMaker;
import org.spring.web.vo.PageVO;
import org.spring.web.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper rmapper;

	@Override
	public PageVO list(Integer bno,Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker(cri, getCountByBno(bno));	
		PageVO pagevo = new PageVO(pageMaker);
		pagevo.setReply(rmapper.list(bno,cri));
		return pagevo;
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		 rmapper.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCountByBno(Integer bno) throws Exception {
		return rmapper.getCountByBno(bno);
	}

}
