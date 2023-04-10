package contagiouscode.mirsengar.busticketbookingbackend.util;

import contagiouscode.mirsengar.busticketbookingbackend.exception.UserException;
import contagiouscode.mirsengar.busticketbookingbackend.model.CurrentUserSession;
import contagiouscode.mirsengar.busticketbookingbackend.model.User;
import contagiouscode.mirsengar.busticketbookingbackend.repository.UserDAO;
import contagiouscode.mirsengar.busticketbookingbackend.repository.UserSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCurrentUserSessionImpl implements GetCurrentUserSession {
          @Autowired
          private UserSessionDAO userSessionDAO;
          @Autowired
          private UserDAO userDAO;
          
          @Override
          public CurrentUserSession getCurrentUserSession ( String key ) {
                    Optional < CurrentUserSession > userOptional = userSessionDAO.findByUuid ( key );
                    if ( userOptional.isPresent ( ) ) {
                              return userOptional.get ( );
                    }
                    else {
                              throw new UserException ( "The user is not authorized" );
                    }
          }
          
          @Override
          public Integer getCurrentUserSessionAdminId ( String key ) {
                    Optional < CurrentUserSession > userOptional = userSessionDAO.findByUuid ( key );
                    if ( userOptional.isPresent ( ) ) {
                              return userOptional.get ( ).getUserId ( );
                    }
                    else {
                              throw new UserException ( "The user is not authorized" );
                    }
          }
          
          @Override
          public User getCurrentUser ( String key ) {
                    Optional < CurrentUserSession > userOptional = userSessionDAO.findByUuid ( key );
                    if ( userOptional.isPresent ( ) ) {
                              Integer id = userOptional.get ( ).getUserId ( );
                              return userDAO.getById ( id );
                    }
                    else {
                              throw new UserException ( "The user is not authorized" );
                    }
          }
}