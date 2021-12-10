package peaksoft.taigan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import peaksoft.taigan.db.domain.model.*;
import peaksoft.taigan.db.repo.*;
import peaksoft.taigan.enums.Direction;
import peaksoft.taigan.enums.State;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final RoleRepo roleRepo;
    private final HostRepo hostRepo;
    private final ClientRepo clientRepo;
    private final OrderRepo orderRepo;
    private final CompanyRepo companyRepo;

    @Autowired
    public DataInitializer(RoleRepo roleRepo, CompanyRepo companyRepo, HostRepo hostRepo, ClientRepo clientRepo, OrderRepo orderRepo) {
        this.roleRepo = roleRepo;
        this.companyRepo = companyRepo;
        this.hostRepo = hostRepo;
        this.clientRepo = clientRepo;
        this.orderRepo = orderRepo;
    }

    @PostConstruct
    public void initDataBaseFilling() {
        roles();
        userHost();
        users();
        orders(0);
    }

    public void users() {

        List<Role> rolesClient = new ArrayList<>();
        rolesClient.add(roleRepo.findById(1l).get());

        Client client1 = new Client();
        client1.setName("Aibek");
        client1.setLogin("client1");
        client1.setPassword("client1");
        client1.setAvatar("avatar");
        client1.setOrders(null);
        client1.setRoles(rolesClient);

        Client client2 = new Client();
        client2.setName("Bekjan");
        client2.setLogin("client2");
        client2.setPassword("client2");
        client2.setAvatar("avatar");
        client1.setOrders(null);
        client2.setRoles(rolesClient);


        List<Role> rolesDriver = new ArrayList<>();
        rolesDriver.add(roleRepo.findById(2l).get());

        Driver driver1 = new Driver();
        driver1.setName("driver1");
        driver1.setLogin("driver1");
        driver1.setPassword("driver1");
        driver1.setAvatar("avatar");
        driver1.setRoles(rolesDriver);

        Driver driver2 = new Driver();
        driver2.setName("driver2");
        driver2.setLogin("driver2");
        driver2.setPassword("driver2");
        driver2.setAvatar("avatar");
        driver2.setRoles(rolesDriver);

        Driver driver3 = new Driver();
        driver3.setName("driver3");
        driver3.setLogin("driver3");
        driver3.setPassword("driver3");
        driver3.setAvatar("avatar");
        driver3.setRoles(rolesDriver);

        Driver driver4 = new Driver();
        driver4.setName("driver4");
        driver4.setLogin("driver4");
        driver4.setPassword("driver4");
        driver4.setAvatar("avatar");
        driver4.setRoles(rolesDriver);



        Order order1 = new Order();
        order1.setOrderTo("Osh");
        order1.setOrderFrom("Bishkek");
        order1.setCodeword(null);
        order1.setComment("comment");
        order1.setDirection(Direction.OSH_CITY);
        order1.setState(State.NEW);

        Order order2 = new Order();
        order2.setOrderTo("Bishkek");
        order2.setOrderFrom("Bishkek");
        order2.setCodeword("codeword1");
        order2.setComment("test");
        order2.setDirection(Direction.BISHKEK);
        order2.setState(State.ON_ROUTE);

        order1.setClient(client1);
        order2.setClient(client1);
        order1.setDriver(driver1);
        order2.setDriver(driver1);
        driver1.setOrders(List.of(order1, order2));
        client1.setOrders(List.of(order1, order2));

        clientRepo.save(client2);

        List<Role> rolesUserOffice = new ArrayList<>();
        rolesUserOffice.add(roleRepo.findById(3l).get());

        UserOffice userOfficeBalykchy = new UserOffice();
        userOfficeBalykchy.setName("UserOfficeBalykchy");
        userOfficeBalykchy.setLogin("UserOfficeBalykchy");
        userOfficeBalykchy.setPassword("UserOfficeBalykchy");
        userOfficeBalykchy.setRoles(rolesUserOffice);

        UserOffice userOfficeOsh = new UserOffice();
        userOfficeOsh.setName("UserOfficeOsh");
        userOfficeOsh.setLogin("UserOfficeOsh");
        userOfficeOsh.setPassword("UserOfficeOsh");
        userOfficeOsh.setDrivers(null);
        userOfficeOsh.setRoles(rolesUserOffice);

        driver1.setUserOffice(userOfficeOsh);
        driver2.setUserOffice(userOfficeOsh);
        driver3.setUserOffice(userOfficeOsh);
        driver4.setUserOffice(userOfficeBalykchy);
        userOfficeOsh.setDrivers(List.of(driver1, driver2, driver3));
        userOfficeBalykchy.setDrivers(List.of(driver4));


//        List<Role> rolesBranch = new ArrayList<>();
//        rolesBranch.add(roleRepo.findById(4l).get());

//        UerOffice balykchy = new UerOffice();
//        balykchy.setName("Balykchy");
//        balykchy.setLogin("Balykchy");
//        balykchy.setPassword("Balykchy");
//        balykchy.setRoles(rolesBranch);
//        balykchy.setUserOffices(null);
//
//        UerOffice osh = new UerOffice();
//        osh.setName("Osh");
//        osh.setLogin("Osh");
//        osh.setPassword("Osh");
//        osh.setRoles(rolesBranch);
//        osh.setUserOffices(null);
//
//        userOfficeBalykchy.setBranch(balykchy);
//        userOfficeOsh.setBranch(osh);
//        balykchy.setUserOffices(List.of(userOfficeBalykchy));
//        osh.setUserOffices(List.of(userOfficeOsh));


        Company company = new Company();
        company.setName("peaksoft");
        company.setLogin("peaksoft");
        company.setPassword("peaksoft");
        List<Role> rolesCom = new ArrayList<>();
        rolesCom.add(roleRepo.findById(4l).get());
        company.setRoles(rolesCom);

        userOfficeBalykchy.setCompany(company);
        userOfficeOsh.setCompany(company);
        company.setUserOffices(List.of(userOfficeBalykchy, userOfficeOsh));

        companyRepo.save(company);

    }

    public void userHost() {
        Host host = new Host();
        host.setName("host");
        host.setLogin("host");
        host.setPassword("host");
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findById(5l).get());
        host.setRoles(roles);
        hostRepo.save(host);
    }

    public void roles() {
        Role role1 = new Role();
        role1.setName("ROLE_CLIENT");

        Role role2 = new Role();
        role2.setName("ROLE_DRIVER");

        Role role3 = new Role();
        role3.setName("ROLE_USER-OFFICE");

//        Role role4 = new Role();
//        role4.setName("ROLE_BRANCH");

        Role role4 = new Role();
        role4.setName("ROLE_COMPANY");

        Role role5 = new Role();
        role5.setName("ROLE_HOST");

        List.of(role1, role2);
        roleRepo.saveAll(List.of(role1, role2, role3, role4, role5));

    }

    public void orders(int size){


        for (int i = 0; i < size; i++) {
            Order order1 = new Order();
            order1.setOrderTo("Osh");
            order1.setOrderFrom("Bishkek");
            order1.setCodeword("s;dfjaserirgksdlfjkasdkfjas;dfjassdj");
            order1.setComment("comment");
            order1.setDirection(Direction.OSH_REG);
            order1.setState(State.ON_ROUTE);

            Order order2 = new Order();
            order2.setOrderTo("Bishkek");
            order2.setOrderFrom("Bishkek");
            order2.setCodeword("rgksderirgksdlfjkasdkfjas;dfjassdj");
            order2.setComment("comment");
            order2.setDirection(Direction.BISHKEK);
            order2.setState(State.DELIVERED);

            orderRepo.saveAll(List.of(order1,order2));

        }



    }
    public void test (Order order1, Order order2,int size){
    }

}
