package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.taigan.db.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query("select o from Order o where o.client.id = :clientId")
    List<Order> findOrdersByClient(Long clientId);

    @Query("select o from Order o where o.driver.id = :driverId")
    List<Order> findOrdersByDriver (Long driverId);

//    Optional<Order> findByCodeword(String code);

    @Query("select o from Order o where o.codeword = :code")
    Optional<Order> findByCodeword(String code);
}
