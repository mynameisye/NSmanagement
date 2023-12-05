package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

import controller.Controller;

public class RegisterUserController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User(
		        -1,
				request.getParameter("userId"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("email"),
				request.getParameter("phone"));
		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
			// 성공 시 사용자 목록 요청으로 redirection
			return "redirect:/user/list";
		} catch (ExistingUserException e) {
			// 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/registerForm.jsp";
		}
	}
}
