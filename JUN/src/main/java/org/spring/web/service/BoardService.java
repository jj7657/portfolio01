package org.spring.web.service;

import java.util.List;

import org.spring.web.vo.BoardVO;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.PageVO;

public interface BoardService {
	
	public PageVO listAll(Criteria cri) throws Exception;
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(BoardVO vo) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(BoardVO vo) throws Exception;
	
	public int getTotalCount() throws Exception;
	
	public void plusViewCnt(BoardVO vo) throws Exception;
	
	public Integer plusLikeCnt(BoardVO vo) throws Exception;
}
