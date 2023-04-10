package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.CancelledBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelledBookingDAO extends JpaRepository < CancelledBooking, Integer > {
}
