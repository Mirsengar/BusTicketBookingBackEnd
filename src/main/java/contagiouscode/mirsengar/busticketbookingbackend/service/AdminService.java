package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.LoginDTO;
import contagiouscode.mirsengar.busticketbookingbackend.model.Admin;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentAdminSession;

public interface AdminService {
          public Admin registerAdmin ( Admin admin );
          
          public CurrentAdminSession loginToAccount ( LoginDTO adminDTO );
          
          public Admin getAdmin ( String key );
          
          public Admin updateAdmin ( Admin admin , String key );
          
          public Admin deleteAdmin ( String key );
          
          public String logOutFromAccount ( String key );
          
}
