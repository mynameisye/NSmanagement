package model;


public class Review { //BoardDTO -> Review
	private String title = null;
	private int MemId = 0;
	private String posted = null;
	private int ReviewId = 0;
	private int SupId = 0;
	private String content = "";
	
	
	public Review() {};
	public Review(int reviewid, int memid, int supid, String title, String posted, String content) {
	    this.ReviewId = reviewid;
	    this.MemId = memid;
	    this.SupId = supid;
	    this.title = title;
	    this.posted = posted;
	    this.content = content;
	};
	
	
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
	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
	
	
	

}