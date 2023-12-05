package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.UserManager;

import controller.Controller;

public class LoginController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			// 모델에 login 처리를 위임
			UserManager.getInstance().login(userId, password);
			// 세션에 userId 저장
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			return "redirect:/user/list"; // 사용자 목록 요청으로 redirection
		} catch (Exception e) {
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			return "/user/loginForm.jsp"; // loginForm 뷰로 forward
		}
	}
}
