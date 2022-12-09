package com.sosnilosm.AnonymousBookReviews.graphql;

import com.sosnilosm.AnonymousBookReviews.book.model.Book;
import com.sosnilosm.AnonymousBookReviews.book.repository.BookRepository;
import com.sosnilosm.AnonymousBookReviews.review.model.Review;
import com.sosnilosm.AnonymousBookReviews.review.repository.ReviewRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Sosnilo
 */
@Controller
public class GraphQlController {
    final BookRepository bookRepository;
    final ReviewRepository reviewRepository;

    public GraphQlController(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    // Books

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Optional<Book> getBookById(@Argument int id) {
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author,
                           @Argument Date pdate, @Argument int amount) {
        Book book = new Book(title, author, pdate, amount);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book updateBook(@Argument int id,
                           @Argument String title, @Argument String author,
                           @Argument Date pdate, @Argument int amount) {
        Optional<Book> bookData = bookRepository.findById(id);

        if (bookData.isPresent()) {
            Book updatedeBook = bookData.get();
            updatedeBook.setTitle(title);
            updatedeBook.setAuthor(author);
            updatedeBook.setPdate(pdate);
            updatedeBook.setAmount(amount);
            return bookRepository.save(updatedeBook);
        } else {
            return null;
        }
    }

    @MutationMapping
    public Optional<Book> deleteBook(@Argument int id) {
        Optional<Book> delBook = this.bookRepository.findById(id);
        bookRepository.deleteById(id);
        return delBook;
    }

    @SchemaMapping
    public List<Review> reviews(@Argument int count,  Book book) {
        return reviewRepository.findReviewsByBookId(book.getId()).stream().limit(count).toList();
    }

    // Reviews

    @QueryMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @QueryMapping
    public Optional<Review> getReviewById(@Argument String id) {
        return reviewRepository.findById(id);
    }

    @MutationMapping
    public Review createReview(@Argument int bookId, @Argument String content) {
        Review review = new Review(bookId, content, LocalDateTime.now());

        return reviewRepository.insert(review);
    }

    @MutationMapping
    public Review updateReview(@Argument String id,
                               @Argument int bookId, @Argument String content) {
        Optional<Review> reviewData = reviewRepository.findById(id);

        if (reviewData.isPresent()) {
            Review updatedeReview = reviewData.get();
            updatedeReview.setBookId(bookId);
            updatedeReview.setContent(content);
            updatedeReview.setPdate(LocalDateTime.now());
            return reviewRepository.save(updatedeReview);
        } else {
            return null;
        }
    }

    @MutationMapping
    public Optional<Review> deleteReview(@Argument String id) {
        Optional<Review> delReview = reviewRepository.findById(id);
        reviewRepository.deleteById(id);
        return delReview;
    }
}
