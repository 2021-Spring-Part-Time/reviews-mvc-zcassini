package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class ReviewController {
    @Resource
    private ReviewRepository reviewRepository;

    @RequestMapping( { "/", "/reviews" } )
    public String findAllReviews(Model model) {
       model.addAttribute("reviews", reviewRepository.findAll());
       return "/reviews";
    }

    @RequestMapping("/review")
    public String findOneReview(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("review", reviewRepository.findOne(id));
        return "review";
    }
}
