package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
