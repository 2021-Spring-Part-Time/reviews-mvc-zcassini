package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {
    private Map<Long, Review> reviewList = new HashMap<>();

    public ReviewRepository() {
        Review smalltalk = new Review(1L, "Smalltalk", Category.DYNAMIC, "The King of OOP.", "/images/smalltalk.svg");
        Review ruby = new Review(2L, "Ruby", Category.DYNAMIC, "Home of the best full stack web framework.", "/images/ruby.svg");
        Review clojure = new Review(3L, "Clojure", Category.DYNAMIC, "Top notch LISP.  Top notch functional programming.", "/images/clojure.svg");
        Review java = new Review(4L, "Java", Category.STATIC, "I guess it's better than writing C++.", "/images/java.svg");

        reviewList.put(smalltalk.id(), smalltalk);
        reviewList.put(ruby.id(), ruby);
        reviewList.put(clojure.id(), clojure);
        reviewList.put(java.id(), java);
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
