package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.LoginDTO;
import contagiouscode.mirsengar.busticketbookingbackend.exception.AdminException;
import contagiouscode.mirsengar.busticketbookingbackend.model.Admin;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentAdminSession;
import contagiouscode.mirsengar.busticketbookingbackend.repository.AdminDAO;
import contagiouscode.mirsengar.busticketbookingbackend.repository.SessionDAO;
import contagiouscode.mirsengar.busticketbookingbackend.util.GetCurrentAdminSessionImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
          @Autowired
          private AdminDAO                   adminDAO;
          @Autowired
          private SessionDAO                 sessionDAO;
          @Autowired
          private GetCurrentAdminSessionImpl getCurrentAdminSession;
          
          @Override
          public Admin registerAdmin ( Admin admin ) {
                    Admin existAdmin = adminDAO.findByMobile ( admin.getMobile ( ) );
                    if ( existAdmin == null ) {
                              return adminDAO.save ( admin );
                    }
                    throw new AdminException ( "Admin already exists" );
          }
          
          @Override
          public CurrentAdminSession loginToAccount ( LoginDTO adminDTO ) {
                    Admin existingAdmin = adminDAO.findByMobile ( adminDTO.getMobile ( ) );
                    if ( existingAdmin != null ) {
                              Optional < CurrentAdminSession > currentAdmin =
                                             sessionDAO.findByAdminId ( existingAdmin.getAdminId ( ) );
                              if ( currentAdmin.isPresent ( ) ) {
                                        throw new AdminException ( "Admin already logged in" );
                              }
                              if ( existingAdmin.getPassword ( ).equals ( adminDTO.getPassword ( ) ) ) {
                                        String key = RandomString.make ( 6 );
                                        CurrentAdminSession currentAdminSession =
                                                       new CurrentAdminSession ( existingAdmin.getAdminId ( ) , key ,
                                                                                 LocalDateTime.now ( ) );
                                        
                                        sessionDAO.save ( currentAdminSession );
                                        return currentAdminSession;
                              }
                    }
                    throw new AdminException ( "Admin does not exist with this given mobile" );
          }
          
          @Override
          public Admin getAdmin ( String key ) {
                    Admin admin = getCurrentAdminSession.getCurrentAdmin ( key );
                    if ( admin != null ) {
                              return admin;
                    }
                    throw new AdminException ( "invalid" );
          }
          
          @Override
          public Admin updateAdmin ( Admin admin , String key ) {
                    Admin currentAdmin = getCurrentAdminSession.getCurrentAdmin ( key );
                    if ( currentAdmin != null ) {
                              Admin existingAdmin = adminDAO.findByMobile ( admin.getMobile ( ) );
                              if ( existingAdmin == null ) {
                                        throw new AdminException ( "Admin Dose Not Exist" );
                              }
                              existingAdmin.setAdminName ( admin.getAdminName ( ) );
                              existingAdmin.setEmail ( admin.getEmail ( ) );
                              existingAdmin.setPassword ( admin.getPassword ( ) );
                              return existingAdmin;
                    }
                    throw new AdminException ( "Invalid UUid" );
          }
          
          @Override
          public Admin deleteAdmin ( String key ) {
                    Admin currentAdmin = getCurrentAdminSession.getCurrentAdmin ( key );
                    if ( currentAdmin != null ) {
                              adminDAO.delete ( currentAdmin );
                              return currentAdmin;
                    }
                    else {
                              throw new AdminException ( "Invalid UUID " );
                    }
          }
          
          @Override
          public String logOutFromAccount ( String key ) {
                    Optional < CurrentAdminSession > currentUserOptional = sessionDAO.findByUuid ( key );
                    if ( ! currentUserOptional.isPresent ( ) ) {
                              throw new AdminException ( "User is not logged in with this number" );
                    }
                    CurrentAdminSession currentAdminSession = getCurrentAdminSession.getCurrentAdminSession ( key );
                    sessionDAO.delete ( currentAdminSession );
                    return "Logged Out...";
          }
}
