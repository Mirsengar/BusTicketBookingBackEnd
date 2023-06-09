package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository < Book, Integer > {
}
