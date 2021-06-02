package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepository;

    @Mock
    private Review reviewOne;

    @Mock Review reviewTwo;

    @Test
    public void shouldBeOkForAllReviewsInTheReviewsTemplate() throws Exception {
       mockMvc.perform(get("/reviews"))
               .andExpect(status().isOk())
               .andExpect(view().name("reviews"));
    }

    @Test
    public void shouldFindAllReviewsInTheModel() throws Exception {
        Collection<Review> allReviewsInModel = Arrays.asList(reviewOne, reviewTwo);
        when(reviewRepository.findAll()).thenReturn(allReviewsInModel);
        mockMvc.perform(get("/reviews"))
                .andExpect(model().attribute("reviewsModel", allReviewsInModel));
    }

    @Test
    public void shouldBeOkForAllReviewOneInTheReviewTemplate() throws Exception {
        mockMvc.perform(get("/review?id=1"))
                .andExpect(status().isOk())
                .andExpect(view().name("review"));
    }

    @Test
    public void shouldFindReviewOneInModel() throws Exception {
        Long reviewOneId = 1L;
        when(reviewRepository.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform((get("/review?id=1")))
                .andExpect(model().attribute("reviewModel", reviewOne));

    }
}
