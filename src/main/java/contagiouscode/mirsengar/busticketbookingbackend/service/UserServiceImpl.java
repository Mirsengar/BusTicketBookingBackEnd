package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.LoginDTO;
import contagiouscode.mirsengar.busticketbookingbackend.exception.AdminException;
import contagiouscode.mirsengar.busticketbookingbackend.exception.UserException;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentUserSession;
import contagiouscode.mirsengar.busticketbookingbackend.model.User;
import contagiouscode.mirsengar.busticketbookingbackend.repository.UserDAO;
import contagiouscode.mirsengar.busticketbookingbackend.repository.UserSessionDAO;
import contagiouscode.mirsengar.busticketbookingbackend.util.GetCurrentUserSession;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
          @Autowired
          private UserDAO               userDAO;
          @Autowired
          private UserSessionDAO        userSessionDAO;
          @Autowired
          private GetCurrentUserSession getCurrentUserSession;
          
          @Override
          public User registeruser ( User user ) {
                    User existingUser = userDAO.findByMobile ( user.getMobile ( ) );
                    if ( existingUser == null ) {
                              return userDAO.save ( user );
                    }
                    throw new UserException ( "User Already Exist" );
          }
          
          @Override
          public CurrentUserSession logIntoAccount ( LoginDTO userDTO ) {
                    User existingUser = userDAO.findByMobile ( userDTO.getMobile ( ) );
                    if ( existingUser != null ) {
                              Optional < CurrentUserSession > userOptional =
                                             userSessionDAO.findByUserId ( existingUser.getUserId ( ) );
                              if ( userOptional.isPresent ( ) ) {
                                        throw new UserException ( "User Already Logged In" );
                              }
                              if ( existingUser.getPassword ( ).equals ( userDTO.getPassword ( ) ) ) {
                                        String key = RandomString.make ( 8 );
                                        CurrentUserSession currentUserSession =
                                                       new CurrentUserSession ( existingUser.getUserId ( ) , key ,
                                                                                LocalDateTime.now ( ) );
                                        userSessionDAO.save ( currentUserSession );
                                        return currentUserSession;
                              }
                              else {
                                        throw new UserException ( "Invalid Mobile Or Password" );
                              }
                    }
                    else {
                              throw new UserException ( "User Does Not Exists" );
                    }
          }
          
          @Override
          public User getUser ( String key ) {
                    User user = getCurrentUserSession.getCurrentUser ( key );
                    if ( user != null ) {
                              return new User ( user.getUserId ( ) , user.getUserName ( ) , user.getEmail ( ) ,
                                                user.getMobile ( ) , user.getPassword ( ) );
                    }
                    else {
                              throw new UserException ( "User Dose Not Exist With This Key" );
                    }
          }
          
          @Override
          public User updateUser ( User user , String key ) {
                    User currentUser = getCurrentUserSession.getCurrentUser ( key );
                    if ( currentUser != null ) {
                              User existingUser = userDAO.findByMobile ( currentUser.getMobile ( ) );
                              if ( existingUser != null ) {
                                        existingUser.setUserName ( user.getUserName ( ) );
                                        existingUser.setEmail ( user.getEmail ( ) );
                                        existingUser.setPassword ( user.getPassword ( ) );
                                        return userDAO.save ( existingUser );
                              }
                              else {
                                        throw new UserException ( "User Does Not Exist With This Mobile " );
                              }
                    }
                    else {
                              throw new UserException ( "User Dose Note Exist With This Key" );
                    }
          }
          
          @Override
          public User deleteuser ( String key ) {
                    User currentUser = getCurrentUserSession.getCurrentUser ( key );
                    if ( currentUser != null ) {
                              userDAO.delete ( currentUser );
                              return currentUser;
                    }
                    else {
                              throw new UserException ( "User does not exist with this key" );
                    }
          }
          
          @Override
          public String logOutFromAccount ( String key ) {
                    Optional < CurrentUserSession > currentUserOptional = userSessionDAO.findByUuid ( key );
                    if ( ! currentUserOptional.isPresent ( ) ) {
                              throw new AdminException ( "User is not logged in with this number" );
                    }
                    CurrentUserSession currentUserSession = getCurrentUserSession.getCurrentUserSession ( key );
                    userSessionDAO.delete ( currentUserSession );
                    return "Logged Out...";
                    
          }
}