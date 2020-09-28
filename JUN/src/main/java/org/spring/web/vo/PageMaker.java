package org.spring.web.vo;

public class PageMaker {
	
	private int total;
	
	private int startpage;
	private int endpage;
	
	private boolean prev;
	private boolean next;
	
	private Criteria cri;
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public PageMaker(Criteria cri,int total) {
		this.cri=cri;
		this.total=total;
		//endpage 계산식
		this.endpage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//startpage 계산식
		this.startpage=this.endpage-9;
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		if (realEnd<endpage) {
			this.endpage=realEnd;
		}
		this.prev=this.startpage>1;
		this.next=this.endpage<realEnd;
	}

	@Override
	public String toString() {
		return "PageMaker [total=" + total + ", startpage=" + startpage + ", endpage=" + endpage + ", prev=" + prev
				+ ", next=" + next + ", cri=" + cri + "]";
	}

}
