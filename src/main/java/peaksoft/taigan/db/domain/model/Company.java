package peaksoft.taigan.db.domain.model;

//import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "companies")
public class Company extends User{

    @OneToMany(cascade = CascadeType.ALL
            ,mappedBy = "company"
            ,fetch = FetchType.LAZY
    )
    private List<UserOffice> userOffices;

    public void addBranchToCompany(UserOffice uerOffice){
        if (userOffices == null){
            userOffices = new ArrayList<>();
        }
        userOffices.add(uerOffice);
        uerOffice.setCompany(this);
    }
}
