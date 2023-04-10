package contagiouscode.mirsengar.busticketbookingbackend.util;

import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentUserSession;
import contagiouscode.mirsengar.busticketbookingbackend.model.User;

public interface GetCurrentUserSession {
          
          public CurrentUserSession getCurrentUserSession ( String key );
          
          public Integer getCurrentUserSessionAdminId ( String key );
          
          public User getCurrentUser ( String key );
          
}