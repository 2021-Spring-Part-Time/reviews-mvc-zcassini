package org.wecancoeit.reviews;

public class Review {
    private Long id;
    private String name;
    private Category category;
    private String content;
    private String image;


    public Review(Long id, String name, Category category, String content, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.content = content;
        this.image = image;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String category() {
        return category.name();
    }

    public String content() {
        return content;
    }

    public String image() {
        return image;
    }
}
