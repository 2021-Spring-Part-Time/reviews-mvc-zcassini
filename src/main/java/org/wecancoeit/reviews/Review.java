package org.wecancoeit.reviews;

public class Review {
    private Long id;
    private String name;

    public Review(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long id() {
        return this.id;
    }
}
