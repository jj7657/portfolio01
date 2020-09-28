package org.spring.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> list(@Param("bno")Integer bno,@Param("cri")Criteria cri) throws Exception;

	public void create(ReplyVO vo) throws Exception;

	public void update(ReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;
	
	public int getCountByBno(Integer bno) throws Exception;
	
}
