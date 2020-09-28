package org.spring.web.service;

import java.util.List;

import org.spring.web.mapper.BoardMapper;
import org.spring.web.vo.BoardVO;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.PageMaker;
import org.spring.web.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public PageVO listAll(Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker(cri, getTotalCount());
		PageVO pagevo = new PageVO(pageMaker);
		pagevo.setBoard(mapper.listAll(cri));
		return pagevo;
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		mapper.create(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		return mapper.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		mapper.update(vo);
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		mapper.delete(vo);
	}


	@Override
	public int getTotalCount() throws Exception {
		return mapper.getTotalCount();
	}
	
	@Override
	public void plusViewCnt(BoardVO vo) throws Exception {
		mapper.plusViewCnt(vo);		
	}

	@Override
	public Integer plusLikeCnt(BoardVO vo) throws Exception {
		mapper.plusLikeCnt(vo);
		return mapper.getLikeCnt(vo);
	}
	
	
	
}
