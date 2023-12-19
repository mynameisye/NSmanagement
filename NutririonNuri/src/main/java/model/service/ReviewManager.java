package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Review;
import model.dao.ReviewDAO;

public class ReviewManager {
    private static ReviewManager reviewMan = new ReviewManager();
    private ReviewDAO reviewDAO;
    
    //생성자
    private ReviewManager() {
        try {
            reviewDAO = new ReviewDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ReviewManager getInstance() {
        return reviewMan;
    }
    
    //전체 목록 불러오기
    public List<Review> findReviewList() throws SQLException {
        return reviewDAO.findBoardList();
    }
    
    //리뷰 검색
    public Review findReview(int reviewId) throws SQLException{
        return reviewDAO.findReview(reviewId);
    }
    
    //findMemberReviewList(userId)
    //내 리뷰 조회 기능
    public List<Review> findMemberReviewList(int userId) throws SQLException {
        return reviewDAO.findMemberBoard(userId);
    }
    
    //add
    public int add(Review review) throws SQLException {
        return reviewDAO.addBoardList(review);
    }
    
    //update
    public int update(Review review) throws SQLException {
        return reviewDAO.updateBoardList(review);
    }
    
    //delete
    public int delete(Review review) throws SQLException {
        return reviewDAO.deleteBoardList(review);
    }
}   
