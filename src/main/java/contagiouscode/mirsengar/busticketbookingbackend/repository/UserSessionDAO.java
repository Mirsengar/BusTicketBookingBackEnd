package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSessionDAO extends JpaRepository < CurrentUserSession, Integer > {
          public Optional < CurrentUserSession > findByUserId ( Integer userId );
          
          public Optional < CurrentUserSession > findByUuid ( String uuid );
          
}