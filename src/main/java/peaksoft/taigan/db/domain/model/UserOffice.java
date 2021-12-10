package peaksoft.taigan.db.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_offices")
public class UserOffice extends User{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
//    @JsonIgnore
    private Company company;

    @OneToMany(cascade = CascadeType.ALL
            ,mappedBy = "userOffice"
            ,fetch = FetchType.LAZY
    )
    private List<Driver> drivers;

    public void addDriverToUserOffice(Driver driver){
        if (driver == null){
            drivers = new ArrayList<>();
        }
        drivers.add(driver);
        driver.setUserOffice(this);
    }



}
