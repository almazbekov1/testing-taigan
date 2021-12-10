package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
