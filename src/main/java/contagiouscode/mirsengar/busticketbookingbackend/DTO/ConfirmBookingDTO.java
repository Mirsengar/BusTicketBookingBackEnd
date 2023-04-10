package contagiouscode.mirsengar.busticketbookingbackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmBookingDTO {
          private LocalDateTime journeyDateTime;
          private String        journeyForm;
          private String        journeyTo;
          private String        bookingNumber;
          private String        busNumber;
}
