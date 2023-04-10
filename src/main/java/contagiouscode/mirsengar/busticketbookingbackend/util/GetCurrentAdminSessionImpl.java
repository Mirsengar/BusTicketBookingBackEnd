package contagiouscode.mirsengar.busticketbookingbackend.util;

import contagiouscode.mirsengar.busticketbookingbackend.exception.AdminException;
import contagiouscode.mirsengar.busticketbookingbackend.model.Admin;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentAdminSession;
import contagiouscode.mirsengar.busticketbookingbackend.repository.AdminDAO;
import contagiouscode.mirsengar.busticketbookingbackend.repository.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCurrentAdminSessionImpl implements GetCurrentAdminSession {
          @Autowired
          private SessionDAO sessionDAO;
          @Autowired
          private AdminDAO adminDAO;
          
          @Override
          public Integer getCurrentAdminSessionAdminId(String key){
                    Optional<CurrentAdminSession> optional = sessionDAO.findByUuid(key);
                    if(!optional.isPresent()) {
                              throw new AdminException("The user is not authorised as Admin");
                    }
                    return optional.get().getAdminId();
          }
          
          @Override
          public Admin getCurrentAdmin(String key) {
                    Optional<CurrentAdminSession> optional = sessionDAO.findByUuid(key);
                    if(!optional.isPresent()) {
                              throw new AdminException("The user is not authorised as Admin");
                    }
                    Integer adminId = optional.get().getAdminId();
                    return  adminDAO.getById(adminId);
          }
          
          @Override
          public CurrentAdminSession getCurrentAdminSession(String key) {
                    Optional<CurrentAdminSession> optional = sessionDAO.findByUuid(key);
                    if (!optional.isPresent()) {
                              throw new AdminException("The user is not authorised as Admin");
                    }
                    return optional.get();
          }
}