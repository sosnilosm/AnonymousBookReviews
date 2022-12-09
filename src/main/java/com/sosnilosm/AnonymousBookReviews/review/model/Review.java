package com.sosnilosm.AnonymousBookReviews.review.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author Sergei Sosnilo
 */
@Document("review")
public class Review {
    @Id
    private String id;
    @Field
    private int bookId;
    @Field
    private String content;
    @Field
    private LocalDateTime pdate;

    public Review() {
    }

    public Review(int bookId, String content, LocalDateTime pdate) {
        this.bookId = bookId;
        this.content = content;
        this.pdate = pdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPdate() {
        return pdate;
    }

    public void setPdate(LocalDateTime pdate) {
        this.pdate = pdate;
    }
}
