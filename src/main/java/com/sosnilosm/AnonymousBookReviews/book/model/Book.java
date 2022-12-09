package com.sosnilosm.AnonymousBookReviews.book.model;

import jakarta.persistence.*;

import java.sql.Date;

/**
 * @author Sergei Sosnilo
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "pdate")
    private Date pdate;
    @Column(name = "amount")
    private int amount;

    public Book() {
    }

    public Book(String title, String author, Date pdate, int amount) {
        this.title = title;
        this.author = author;
        this.pdate = pdate;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pdate=" + pdate +
                ", amount=" + amount +
                '}';
    }
}
