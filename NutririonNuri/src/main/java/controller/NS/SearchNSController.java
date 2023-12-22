package controller.NS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.NS;
import model.service.NSManager;

public class SearchNSController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        NSManager manager = NSManager.getInstance();
        String keyword = request.getParameter("keyword");
        String option = request.getParameter("searchOption");

        List<NS> nsList = manager.findNSList(keyword, option);    
        request.setAttribute("nsList", nsList);  
        
        return "/ns/search_list.jsp";                
    }
}
