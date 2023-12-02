package model;


public class BoardDTO {
	private String title = null;
	private int MemId = 0;
	private String date = null;
	private int ReviewId = 0;
	private int SupId = 0;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMemId() {
		return MemId;
	}
	public void setMemId(int memId) {
		MemId = memId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReviewId() {
		return ReviewId;
	}
	public void setReviewId(int reviewId) {
		ReviewId = reviewId;
	}
	public int getSupId() {
		return SupId;
	}
	public void setSupId(int supId) {
		SupId = supId;
	}
	
	
	

}
