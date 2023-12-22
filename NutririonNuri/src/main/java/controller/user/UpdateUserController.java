package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;
import model.MemberInfo;
import model.User;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		String updateId = request.getSession().getAttribute(UserSessionUtils.USER_SESSION_KEY).toString(); 

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);	
			
			MemberInfo memberInfo = manager.findMemberInfo(user.getMemid());
			request.setAttribute("memberInfo", memberInfo);
			
			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(updateId, session)) {
				return "/user/personal_management.jsp";     
			}    
			
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/user/personal_management.jsp";
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	
    	//null값 예외처리
    	String smoke = request.getParameter("smoke");
    	String alchol = request.getParameter("alchol");
    	String pregnant = request.getParameter("pregnant");
    	char smoke2 = 'x';
    	char alchol2 = 'x';
    	char pregnant2 = 'x';
    	if (smoke != null) { smoke2 = smoke.charAt(0); }
    	if (alchol != null) { alchol2 = alchol.charAt(0); }
    	if (pregnant != null) { pregnant2 = pregnant.charAt(0); }
    	
    	MemberInfo updateMemberInfo = new MemberInfo(
    	        Float.parseFloat(request.getParameter("height")),
    	        Float.parseFloat(request.getParameter("weight")),
    	        smoke2,
    	        alchol2,
    	        pregnant2,
    	        request.getParameter("medicine"),
    	        request.getParameter("supplement"),
    	        request.getParameter("favor")
    	        );
    	
    	String id = request.getParameter("id");
    	
    	log.debug("Update User : {}", updateMemberInfo);

		UserManager manager = UserManager.getInstance();
		manager.update(updateMemberInfo, id);
		
        return "redirect:/home";			
    }
}