package contagiouscode.mirsengar.busticketbookingbackend.service;

import contagiouscode.mirsengar.busticketbookingbackend.DTO.ConfirmBookingDTO;
import contagiouscode.mirsengar.busticketbookingbackend.model.Book;
import contagiouscode.mirsengar.busticketbookingbackend.model.Bus;
import contagiouscode.mirsengar.busticketbookingbackend.model.CancelledBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {
          @Override
          public Bus addBus ( Bus bus , String key ) {
                    return null;
          }
          
          @Override
          public Bus updateBus ( Bus bus , String key ) {
                    return null;
          }
          
          @Override
          public Bus removeBus ( String busNumber , String key ) {
                    return null;
          }
          
          @Override
          public List < Bus > getAllBus ( ) {
                    return null;
          }
          
          @Override
          public List < Bus > getAllBusBySD ( String source , String destination ) {
                    return null;
          }
          
          @Override
          public Book bookBus ( Book book , String userkey ) {
                    return null;
          }
          
          @Override
          public ConfirmBookingDTO confirmTicketBooking ( String userkey , Integer bookId ) {
                    return null;
          }
          
          @Override
          public String cancelBooking ( String userkey , CancelledBooking cancelBookDTO , Integer bookId ) {
                    return null;
          }
          
          @Override
          public Book getBookingDetails ( String userKey , Integer bookId ) {
                    return null;
          }
}
