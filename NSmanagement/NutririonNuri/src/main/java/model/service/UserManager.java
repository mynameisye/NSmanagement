package model.service;

import java.sql.SQLException;
import java.util.List;

import model.User;
import model.dao.ReviewDAO;
import model.dao.UserDAO;


public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;
	private ReviewDAO reviewDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
			reviewDAO = new ReviewDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	//add
	public int add(User user) throws SQLException, ExistingUserException{
	    if(userDAO.existingUser(user.getId())==true) {
	        throw new ExistingUserException(user.getId()+"는 이미 존재하는 아이디입니다.");
	    }
	    return userDAO.addUser(user);
	}
	
	//update
	public int update(User user) throws SQLException{
	    return userDAO.updateUser(user);
	}
	
	//delete
	public int delete(String userId) throws SQLException{
	    return userDAO.deleteUser(userId);
	}
	
	//findUser
	public User findUser(String userId) throws SQLException, UserNotFoundException {
	    User user = userDAO.findUser(userId);
	    
	    if(user == null) {
	        throw new UserNotFoundException(userId+"는 존재하지 않는 아이디입니다.");
	    }
	    
	    return user;
	}

    public void login(String userId, String password) {
        // TODO Auto-generated method stub
        
    }
}
