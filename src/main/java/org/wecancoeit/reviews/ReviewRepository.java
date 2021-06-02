package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {
    private Map<Long, Review> reviewList = new HashMap<Long, Review>();

    public ReviewRepository(Review review) {
        reviewList.put(review.id(), review);
    }

    public ReviewRepository(Review ...reviews) {
        Arrays.stream(reviews).forEach(review -> reviewList.put(review.id(), review));
    }

    public Review findOne(long id) {
        return reviewList.get(id);
    }

    public Collection<Review> findAll() {
        return reviewList.values();
    }
}
