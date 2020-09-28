package org.spring.web.vo;

import java.util.List;

public class PageVO {
	
	private List<ReplyVO> reply;
	private List<BoardVO> board;
	
	private PageMaker pageMaker;

	public PageVO(PageMaker pageMaker) {
		this.pageMaker = pageMaker;
	}
	

	public List<ReplyVO> getReply() {
		return reply;
	}

	public void setReply(List<ReplyVO> reply) {
		this.reply = reply;
	}

	public List<BoardVO> getBoard() {
		return board;
	}

	public void setBoard(List<BoardVO> board) {
		this.board = board;
	}

	public PageMaker getPageMaker() {
		return pageMaker;
	}

	public void setPageMaker(PageMaker pageMaker) {
		this.pageMaker = pageMaker;
	}

	@Override
	public String toString() {
		return "PageVO [reply=" + reply + ", board=" + board + ", pageMaker=" + pageMaker + "]";
	}

	


}
