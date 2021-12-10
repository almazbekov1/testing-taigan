package peaksoft.taigan.db.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import peaksoft.taigan.enums.Direction;
import peaksoft.taigan.enums.State;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
//@ApiModel
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_to")
    private String orderTo;

    @Column(name = "order_from")
    private String orderFrom;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    @JsonIgnore
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;


    private String codeword;
    private String comment;
    private Direction direction;


    private State state;



}
