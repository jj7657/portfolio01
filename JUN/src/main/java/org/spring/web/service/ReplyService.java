package org.spring.web.service;

import java.util.List;

import org.spring.web.vo.Criteria;
import org.spring.web.vo.PageVO;
import org.spring.web.vo.ReplyVO;

public interface ReplyService {
	
	public PageVO list(Integer bno,Criteria cri) throws Exception;

	public void create(ReplyVO vo) throws Exception;

	public void update(ReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;
	
	public int getCountByBno(Integer bno) throws Exception;
}
