package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDAO extends JpaRepository < Passenger, Integer > {
}
