package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
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
       	User user = new User();
		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "redirect:/template/index";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/template/member.jsp";
		}
    }
}

