package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.ConfirmBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmBookingDAO extends JpaRepository < ConfirmBooking, Integer > {
          public ConfirmBooking findByBookingId ( String bookingId );
}
