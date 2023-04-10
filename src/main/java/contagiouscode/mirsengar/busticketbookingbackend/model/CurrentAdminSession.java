package contagiouscode.mirsengar.busticketbookingbackend.model;

import io.swagger.models.auth.In;
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
public class CurrentAdminSession {
          @Id
          @GeneratedValue ( strategy = GenerationType.AUTO)
          private Integer       id;
          private Integer       adminId;
          private String        uuid;
          private LocalDateTime localDateTime;
          
          public CurrentAdminSession ( Integer adminId , String uuid , LocalDateTime localDateTime ) {
                    super ( );
                    this.adminId       = adminId;
                    this.uuid          = uuid;
                    this.localDateTime = localDateTime;
          }
          
}