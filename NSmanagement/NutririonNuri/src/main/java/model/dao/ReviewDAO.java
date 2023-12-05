package model.dao;

import java.util.List;
import model.Review;
import java.util.ArrayList;
import java.sql.*;


public class ReviewDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ReviewDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	
	private static String query = "SELECT BOARD.MEMID, " +
									"REVIEW.TITLE, " +
									"REVIEW.POSTED";
	
	public List<Review> findBoardList(){
		String allQuery = query + "," + "REVIEW.REVIEWID, " +
				"REVIEW.SUPID " + "FROM REVIEW ORDER BY REVIEW.REVIEWID";

		
		jdbcUtil.setSqlAndParameters(allQuery, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Review> list = new ArrayList<Review>();
			while(rs.next()) {
				Review dto = new Review();
				dto.setMemId(rs.getInt("MEMID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setDate(rs.getString("POSTED"));
				dto.setReviewId(rs.getInt("REVIEWID"));
				dto.setSupId(rs.getInt("SUPID"));
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}		
		return null;
		
	}
	
	public List<Review> findMemberBoard(int memID) {
		String memQuery = query + "," + "REVIEW.REVIEWID, " +
				"REVIEW.SUPID " + "FROM REVIEW ORDER BY REVIEW.REVIEWID" +
				"WHERE REVIEW.MEMID = ?";
		
		Object[] param = new Object[] { memID };
		jdbcUtil.setSqlAndParameters(memQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Review> list = new ArrayList<Review>();
			
			while(rs.next()) {
				Review dto = new Review();
				dto.setMemId(rs.getInt("MEMID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setDate(rs.getString("POSTED"));
				dto.setReviewId(rs.getInt("REVIEWID"));
				dto.setSupId(rs.getInt("SUPID"));
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		return null;
		
	}
	
	
	public int addBoardList(Review brd) {
		int result = 0;
		
		String insert = "INSERT INTO REVIEW (MEMID, TITLE, POSTED, " +
							"REVIEWID, SUPID) " +
							"VALUES (?, ?, ?, reviewseq.nextval, ?)";
		
		Object[] param = new Object[] {brd.getMemId(), brd.getTitle(), brd.getDate(), brd.getSupId()};
		
		jdbcUtil.setSqlAndParameters(insert, param);
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		
		return 1;
	}
	
	
	public int updateBoardList(Review brd) {
		int result = 0;
		
		String update = "UPDATE REVIEW  " + 
						"SET TITLE=? " + "WHERE REVIEWID=?";
		
		Object[] param = new Object[] {brd.getTitle(), brd.getReviewId()};
		
		jdbcUtil.setSqlAndParameters(update, param);
		
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		
		return 1;
	}
	

	public int deleteBoardList(Review brd) {
		int result = 0;
		
		String delete = "DELETE FROM BOARD " +
						"WHERE REVIEW_ID=?";

		Object[] param = new Object[] {brd.getReviewId()};
		
		jdbcUtil.setSqlAndParameters(delete, param);
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		
		return 1;
	}
	
	
}