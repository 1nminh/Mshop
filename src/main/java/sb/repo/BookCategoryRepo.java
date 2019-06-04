package sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sb.entity.BookCategory;

public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer>{

}
