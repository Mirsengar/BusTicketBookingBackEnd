package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.LoginDTO;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentUserSession;
import contagiouscode.mirsengar.busticketbookingbackend.model.User;

public interface UserService {
          public User registeruser ( User user );
          
          public CurrentUserSession logIntoAccount ( LoginDTO loginDTO );
          
          public User getUser ( String key );
          
          public User updateUser ( User user , String key );
          
          public User deleteuser ( String key );
          
          public String logOutFromAccount ( String key );
}
