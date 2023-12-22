package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MemberInfo;
import model.User;
import model.dao.MemberInfoDAO;
import model.dao.UserDAO;


public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;
	private MemberInfoDAO memberInfoDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
			memberInfoDAO = new MemberInfoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	//add
	public int create(User user) throws SQLException, ExistingUserException{
	    if(userDAO.existingUser(user.getId())==true) {
	        throw new ExistingUserException(user.getId()+"는 이미 존재하는 아이디입니다.");
	    }
	    return userDAO.addUser(user);
	}
	
	public int createMemberInfo(int memId) throws SQLException {
	    return memberInfoDAO.createMemberInfo(memId);
	}
	
	//update
	public int update(MemberInfo updateMemberInfo, String id) throws SQLException{
	    return memberInfoDAO.updateMemberInfo(updateMemberInfo, id);
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
	
	//findUserList
	public List<User> findUserList() throws SQLException{
	    return userDAO.findUserList();
	}

	public boolean login(String userId, String password)
	        throws SQLException, UserNotFoundException, PasswordMismatchException {
	        User user = findUser(userId);

	        if (!user.matchPassword(password)) {
	            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
	        }
	        return true;
	    }
    
    public int remove(String userId) throws SQLException, UserNotFoundException {
        return userDAO.deleteUser(userId);
    }
    
    public MemberInfo findMemberInfo(int memId) throws SQLException{
        return memberInfoDAO.findMemberInfo(memId);
    }
}
