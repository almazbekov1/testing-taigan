package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.taigan.db.domain.model.UserOffice;

@Repository
public interface UserOfficeRepo extends JpaRepository<UserOffice,Long> {

}
