package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.ConfirmBookingDTO;
import contagiouscode.mirsengar.busticketbookingbackend.model.Book;
import contagiouscode.mirsengar.busticketbookingbackend.model.Bus;
import contagiouscode.mirsengar.busticketbookingbackend.model.CancelledBooking;

import java.util.List;

public interface BusService {
          public Bus addBus ( Bus bus , String key );
          
          public Bus updateBus ( Bus bus , String key );
          
          public Bus removeBus ( String busNumber , String key );
          
          public List < Bus > getAllBus ( );
          
          public List < Bus > getAllBusBySD ( String source , String destination );
          
          public Book bookBus ( Book book , String userkey );
          
          public ConfirmBookingDTO confirmTicketBooking ( String userkey , Integer bookId );
          
          public String cancelBooking ( String userkey , CancelledBooking cancelBookDTO , Integer bookId );
          
          public Book getBookingDetails ( String userKey , Integer bookId );
}
