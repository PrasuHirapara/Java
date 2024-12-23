package prasu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prasu.Entity.PasswordResendToken;

@Repository
public interface PasswordResendRepository extends JpaRepository<PasswordResendToken, Long> {
    PasswordResendToken findByToken(String token);
}
