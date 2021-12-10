package peaksoft.taigan.db.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "drivers")
public class Driver extends User{

    private String avatar;


    @OneToMany(cascade = CascadeType.ALL
            ,mappedBy = "driver"
            ,fetch = FetchType.LAZY
    )
    private List<Order> orders;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_office_id")
    @JsonIgnore
    private UserOffice userOffice;


    public void addOrderToDriver(Order order){
        if (orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setDriver(this);
    }

    private boolean isWorks;
}
