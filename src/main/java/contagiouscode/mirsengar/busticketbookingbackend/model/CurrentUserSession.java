package contagiouscode.mirsengar.busticketbookingbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrentUserSession {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer       id;
          private Integer       userId;
          private String        uuid;
          private LocalDateTime localDateTime;
          
          public CurrentUserSession ( Integer userId , String uuid , LocalDateTime localDateTime ) {
                    super ( );
                    this.userId        = userId;
                    this.uuid          = uuid;
                    this.localDateTime = localDateTime;
          }
          
          
}