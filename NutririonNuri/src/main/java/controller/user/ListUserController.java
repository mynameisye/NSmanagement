package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.service.UserManager;

public class ListUserController implements Controller {
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
		if (!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login"; // login form 요청으로 redirect
		}
		UserManager manager = UserManager.getInstance();
		List<User> userList = manager.findUserList();
		// userList 객체를 request 객체에 저장하여 뷰에 전달
		request.setAttribute("userList", userList);
		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));
		// 사용자 목록 출력 view로 이동 (forwarding)
		return "/template/member.jsp";
	}
}
