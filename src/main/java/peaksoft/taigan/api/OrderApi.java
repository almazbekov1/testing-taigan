package peaksoft.taigan.api;

//import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.taigan.db.domain.dto.OrderView;
import peaksoft.taigan.db.domain.model.Order;
import peaksoft.taigan.db.domain.object.OrderResponse;
import peaksoft.taigan.db.repo.OrderRepo;
import peaksoft.taigan.db.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
//@Api(description = "Контроллер для управления продуктами")
//@Api(value = "Swagger2DemoRestController",description = "")
public class OrderApi {

    @Autowired
    private OrderRepo orderRepo;

    private final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public OrderResponse getAllOrders(@RequestParam Integer page, @RequestParam Integer size) {
        return orderService.getAllOrders(page, size);
    }

    @GetMapping("/client/{id}")
    public List<Order> getAllOrderClients(@PathVariable Long id) {
        System.out.println(orderRepo.findAll());
        return orderService.getAllOrdersClients(id);
    }

    @GetMapping("/driver/{id}")
    public List<Order> getAllOrdersDrivers(@PathVariable Long id) {
        return orderService.getAllOrdersDrivers(id);
    }

    @GetMapping("/{id}")
    public OrderView getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/code/{id}")
    public Order orderScan(@RequestParam String code,@PathVariable Long id) {


        Order order = orderService.get(code,id);
        System.out.println();
        System.out.println(order.getState());
        System.out.println();
        return order;
    }

}
