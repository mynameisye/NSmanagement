package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Review;
import model.service.ReviewManager;
import model.service.UserManager;

import controller.Controller;

public class DeleteReviewController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteReviewController.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Review review = new Review();      
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.delete(review);
            
            log.debug("Delete Review : {}", review);
            return "redirect:/review/list";  // 성공 시 커뮤니티 리스트 화면으로 redirect
            
        } catch (Exception e) {     // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("deleteFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/review_list.jsp";
        }
    }
}
