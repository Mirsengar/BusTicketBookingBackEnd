package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer id;
          @NotNull
          private String  passengerName;
          @NotNull
          private String  gender;
          @NotNull
          private Integer age;
          @Email
          @NotNull
          private String  email;
          @Pattern ( regexp = "[a-zA-Z0-9]{6,12}", message = "Mobile number is not proper")
          @NotNull
          private String  mobile;
}
