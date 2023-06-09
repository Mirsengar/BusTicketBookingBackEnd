package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository < Address, Integer > {
}
