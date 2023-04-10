package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer            busId;
          @NotNull
          private String             sourceStation;
          @NotNull
          private String             busNumber;
          @NotNull
          private Integer            availableSeats;
          @NotNull
          private Integer            farePerSeats;
          @OneToMany ( cascade = CascadeType.ALL)
          private List < BusTiming > busTiming;
}
