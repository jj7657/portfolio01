package org.spring.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.web.vo.BoardVO;
import org.spring.web.vo.Criteria;

public interface BoardMapper {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(BoardVO vo) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(BoardVO vo) throws Exception;

	public List<BoardVO> listAll(@Param("cri")Criteria cri) throws Exception;
	
	public int getTotalCount() throws Exception;
	
	public void plusViewCnt(BoardVO vo) throws Exception;
	
	public void plusLikeCnt(BoardVO vo) throws Exception;
	
	public Integer getLikeCnt(BoardVO vo) throws Exception;
}
