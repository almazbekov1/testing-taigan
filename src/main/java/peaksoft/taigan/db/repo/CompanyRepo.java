package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.Company;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
