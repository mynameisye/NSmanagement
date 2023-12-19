package controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Review;
import model.User;
import model.service.ReviewManager;
import model.service.UserManager;

import controller.Controller;
import controller.user.UserSessionUtils;

public class UpdateReviewController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateReviewController.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {    
            log.debug("UpdateReviewForm Request");
            
            String updateId = request.getParameter("reviewId");
            
            ReviewManager manager = ReviewManager.getInstance();
            Review review = manager.findReview(Integer.parseInt(updateId));

            request.setAttribute("review", review);         

            return "/review/review_write.jsp";
        }  
        
        
        Review review = new Review(
                -1, //reviewid
                Integer.parseInt(request.getParameter("memid")), //memid
                Integer.parseInt(request.getParameter("supid")), //supid
                request.getParameter("title"),
                null, //posted
                request.getParameter("contents")
                );     
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.update(review);
            
            log.debug("Update Review : {}", review);
            return "redirect:/review/list";  // 성공 시 커뮤니티 리스트 화면으로 redirect
            
        } catch (Exception e) {     // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("updateFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/review_list.jsp";
        }
    }
}
