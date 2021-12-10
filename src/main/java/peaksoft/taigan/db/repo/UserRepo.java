package peaksoft.taigan.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.taigan.db.domain.model.User;

import java.util.Optional;

public interface  UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String username);

}
