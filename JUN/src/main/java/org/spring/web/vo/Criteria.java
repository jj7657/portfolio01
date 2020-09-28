package org.spring.web.vo;

public class Criteria {
	
	// 페이지번호
	private int pageNum;
	// 페이지당 데이터 수
	private int amount;
	
	private String type;
	
	private String keyword;
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if (pageNum<=0) {
			pageNum=1;
			return;
		}
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		if (amount<=0 || amount >100) {
			this.amount=10;
			return;
		}
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	//생성자
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum,int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public int getPageStart() {
		return (this.pageNum-1)*amount;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
	
}
