package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Review;
import model.service.ReviewManager;
import model.service.UserManager;

import controller.Controller;

public class AddReviewController implements Controller  {
    private static final Logger log = LoggerFactory.getLogger(AddReviewController.class);
    
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Review review = new Review(/*내용필요*/);
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.add(review);
            
            log.debug("Create Review: {}", review);
            return "redirect:/"; //경로 추가
        } catch (Exception e) {
            request.setAttribute("addFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/review_list.jsp";
        }
    }
    
}
