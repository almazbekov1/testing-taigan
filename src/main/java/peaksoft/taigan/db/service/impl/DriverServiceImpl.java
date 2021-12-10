package peaksoft.taigan.db.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.taigan.db.domain.model.Driver;
import peaksoft.taigan.db.repo.DriverRepo;
import peaksoft.taigan.db.service.DriverService;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepo driverRepo;

    public DriverServiceImpl(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }
}
