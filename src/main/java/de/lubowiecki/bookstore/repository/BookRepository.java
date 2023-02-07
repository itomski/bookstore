package de.lubowiecki.bookstore.repository;

import de.lubowiecki.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
