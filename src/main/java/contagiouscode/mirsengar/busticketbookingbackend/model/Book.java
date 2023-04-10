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
public class Book {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer            bookId;
          @NotNull
          private Integer            noOfSeats;
          @NotNull
          private String             sourceStation;
          @NotNull
          private String             destinationStation;
          @NotNull
          private String             busNumber;
          @OneToOne ( cascade = CascadeType.ALL)
          private BusTiming          busTiming;
          @OneToMany ( cascade = CascadeType.ALL)
          private List < Passenger > passenger;
          @OneToOne ( cascade = CascadeType.ALL)
          private Address            address;
          
}
