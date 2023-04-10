package contagiouscode.mirsengar.busticketbookingbackend.repository;

import contagiouscode.mirsengar.busticketbookingbackend.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusDAO extends JpaRepository < Bus, Integer > {
          public Bus findByBusNumber ( String busNumber );
          
          public List < Bus > findBySourceStationAndDestinationStation (
                         String sourceStation ,
                         String destinationStation
                                                                       );
}
