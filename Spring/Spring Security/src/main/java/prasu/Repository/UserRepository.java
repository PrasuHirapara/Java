package prasu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prasu.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
