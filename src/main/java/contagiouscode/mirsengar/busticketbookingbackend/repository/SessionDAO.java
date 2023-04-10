package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentAdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionDAO extends JpaRepository < CurrentAdminSession, Integer > {
          public Optional < CurrentAdminSession > findByAdminId ( Integer adminId );
          
          public Optional < CurrentAdminSession > findByUuid ( String uuid );
}
