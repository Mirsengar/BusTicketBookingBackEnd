package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusTiming {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer       id;
          @NotNull
          private LocalDateTime departureTime;
          @NotNull
          private LocalDateTime reachTime;
          
}
