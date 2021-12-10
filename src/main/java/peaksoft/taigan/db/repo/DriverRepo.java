package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long> {
}
