package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.MemberInfo;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");

			return "/user/member.jsp";
	    }

    	// POST request (회원정보가 parameter로 전송됨)
       	
       	String mail1 = request.getParameter("mail1");
        String mail2 = request.getParameter("mail2");
        String mail = mail1 + "@" + mail2;
        
       	User user = new User(
       	     request.getParameter("member_id"),
       	     request.getParameter("member_pw"),
       	     request.getParameter("member_name"),
       	     request.getParameter("gender").charAt(0),
       	     request.getParameter("member_phone"),
       	     mail
       	     );
		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
			User user2 = manager.findUser(user.getId());
			manager.createMemberInfo(user2.getMemid());
			
	        return "redirect:/home";
	        
		} catch (ExistingUserException e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/member.jsp";
		}
    }
}

