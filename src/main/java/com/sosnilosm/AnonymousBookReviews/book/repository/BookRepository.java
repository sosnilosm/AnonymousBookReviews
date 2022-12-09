package com.sosnilosm.AnonymousBookReviews.book.repository;

import com.sosnilosm.AnonymousBookReviews.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Sosnilo
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
