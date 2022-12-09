package com.sosnilosm.AnonymousBookReviews.review.repository;

import com.sosnilosm.AnonymousBookReviews.review.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sergei Sosnilo
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findReviewsByBookId(int bookId);
}
