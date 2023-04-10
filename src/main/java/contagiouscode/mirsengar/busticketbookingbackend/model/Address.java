package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          public Integer id;
          @NotNull
          public String  street;
          @NotNull
          public String  city;
          @NotNull
          public String  state;
}
