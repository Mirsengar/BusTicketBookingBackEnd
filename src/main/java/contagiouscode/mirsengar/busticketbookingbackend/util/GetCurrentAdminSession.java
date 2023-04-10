package contagiouscode.mirsengar.busticketbookingbackend.util;

import contagiouscode.mirsengar.busticketbookingbackend.model.Admin;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentAdminSession;


public interface GetCurrentAdminSession {
          public CurrentAdminSession getCurrentAdminSession ( String key );
          
          public Integer getCurrentAdminSessionAdminId ( String key );
          
          public Admin getCurrentAdmin ( String key );
          
}