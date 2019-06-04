package sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sb.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
