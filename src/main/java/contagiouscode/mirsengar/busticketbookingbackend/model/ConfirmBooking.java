package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmBooking {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer id;
          private String  bookingId;
          private Integer totalSeats;
          private Integer totalFare;
          
          public ConfirmBooking ( String bookingId , Integer totalSeats , Integer totalFare ) {
                    super ( );
                    this.bookingId  = bookingId;
                    this.totalFare  = totalFare;
                    this.totalSeats = totalSeats;
          }
}
