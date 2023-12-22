package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = request.getParameter("id");
		String password = request.getParameter("pwd");
		
		try {
			UserManager manager = UserManager.getInstance();
			manager.login(userId, password);
	
			// 세션에 사용자 아이디 저장
			HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
            
            session.setAttribute("curUserId", 
                    UserSessionUtils.getLoginUserId(request.getSession()));
            session.setAttribute("curUserName", manager.findUser(userId).getName());
            return "redirect:/home";
            
		} catch (Exception e) {
		    request.setAttribute("loginFailed", true);
            request.setAttribute("exception", e);
            return "/home/home.jsp";			
		}	
    }
}