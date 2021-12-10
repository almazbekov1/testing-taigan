package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.Host;

public interface HostRepo extends JpaRepository<Host,Long> {
}
