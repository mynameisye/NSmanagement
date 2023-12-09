package controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Review;
import model.service.ReviewManager;

import controller.Controller;

public class ListReviewController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(ListReviewController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReviewManager manager = ReviewManager.getInstance();
        List<Review> reviewList = manager.findReviewList();
        
        request.setAttribute("reviewList", reviewList);
        return "/review/review_list.jsp";
    }
}
