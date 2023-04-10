package contagiouscode.mirsengar.busticketbookingbackend.controller;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.ConfirmBookingDTO;
import contagiouscode.mirsengar.busticketbookingbackend.DTO.LoginDTO;
import contagiouscode.mirsengar.busticketbookingbackend.model.*;
import contagiouscode.mirsengar.busticketbookingbackend.service.BusServiceImpl;
import contagiouscode.mirsengar.busticketbookingbackend.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
          @Autowired
          private UserServiceImpl userService;
          
          @PostMapping ( "/user")
          public User registerUser ( @Valid @RequestBody User user ) {
                    return userService.registeruser ( user );
          }
          
          @PostMapping ( "/loginUser")
          public CurrentUserSession logIntoAccountHandler ( @RequestBody LoginDTO userDTO ) {
                    return userService.logIntoAccount ( userDTO );
          }
          
          @GetMapping ( "/getUser")
          public User getUser ( @RequestParam String key ) {
                    return userService.getUser ( key );
          }
          
          @PutMapping ( "/updateUser")
          public User updateUser ( @RequestBody User user , @RequestParam String key ) {
                    return userService.updateUser ( user , key );
          }
          
          @DeleteMapping ( "/deleteUser")
          public User deleteUser ( @RequestParam String key ) {
                    return userService.deleteuser ( key );
          }
          
          @PatchMapping ( "/logoutUser")
          public String logOutIntoAccount ( @RequestParam String key ) {
                    return userService.logOutFromAccount ( key );
          }
          
          @Autowired
          private BusServiceImpl busServiceImpl;
          
          @PostMapping ( "/book")
          public Book bookTheSeat ( @Valid @RequestBody Book book , @RequestParam String userKey ) {
                    return busServiceImpl.bookBus ( book , userKey );
          }
          
          @PostMapping ( "/confirmBooking/{bookId}")
          public ConfirmBookingDTO confirmBooking ( @RequestParam String userKey , @PathVariable Integer bookId ) {
                    return busServiceImpl.confirmTicketBooking ( userKey , bookId );
          }
          
          @DeleteMapping ( "/cancelBooking/{bookId}")
          public String cancelBooking (
                         @RequestParam String userKey , @RequestBody CancelledBooking cancelBookDTO ,
                         @PathVariable Integer bookId
                                      ) {
                    return busServiceImpl.cancelBooking ( userKey , cancelBookDTO , bookId );
          }
          
          @GetMapping ( "/bookingDetails/{bookId}")
          public Book getBookingDetails ( @RequestParam String userKey , @PathVariable Integer bookId ) {
                    return busServiceImpl.getBookingDetails ( userKey , bookId );
          }
          
          @GetMapping ( "/getBusBySourceAndDestination/{source}/{destination}")
          public List < Bus > getBusBySD ( @PathVariable String source , @PathVariable String destination ) {
                    return busServiceImpl.getAllBusBySD ( source , destination );
          }
}
