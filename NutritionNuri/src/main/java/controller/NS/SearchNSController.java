package controller.NS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.NS;
import model.service.UserManager;

public class SearchNSController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        UserManager manager = UserManager.getInstance();
        String keyword = request.getParameter("keyword");
        String option = request.getParameter("searchOption");
        
        List<NS> nsList = null;
        nsList = manager.findNSList(keyword, option);    
           
        request.setAttribute("nsList", nsList);                    
        return "/nutritionalSupplement/list.jsp";                
    }

}
