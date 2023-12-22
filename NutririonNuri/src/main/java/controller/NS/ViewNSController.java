package controller.NS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.NS;
import model.service.NSManager;

public class ViewNSController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        NSManager manager = NSManager.getInstance();
        String nsId = request.getParameter("nsId");
        
        NS ns = manager.findNS(Integer.parseInt(nsId));    // 영양제 정보 검색
        
        request.setAttribute("ns", ns);     // 영양제 정보 저장                
        return "/ns/ns_view.jsp";                // 영양제 보기 화면으로 이동
    }
}
