package contagiouscode.mirsengar.busticketbookingbackend.model;

import io.swagger.models.auth.In;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CancelledBooking {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer id;
          private String  bookingId;
          private Integer totalSeats;
          private Integer totalFare;
          
          public CancelledBooking ( String bookingId , Integer totalFare , Integer totalSeats ) {
                    super ( );
                    this.bookingId  = bookingId;
                    this.totalFare  = totalFare;
                    this.totalSeats = totalSeats;
          }
}
