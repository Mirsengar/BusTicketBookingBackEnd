package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository < User, Integer> {
          
          public User findByMobile(String mobile);
          
}