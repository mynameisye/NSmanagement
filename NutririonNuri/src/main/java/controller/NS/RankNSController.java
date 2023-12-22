package controller.NS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.NS;
import model.service.NSManager;

public class RankNSController implements Controller{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        NSManager manager = NSManager.getInstance();

        List<NS> nsList = manager.findStarList();    
        request.setAttribute("nsList", nsList);  
        
        return "/home/home.jsp";                
    }
}
