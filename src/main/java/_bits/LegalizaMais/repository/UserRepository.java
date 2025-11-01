package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByOrderByNameAsc();

    boolean existsByEmail(String email);

    boolean existsByDocument(String document);

    Optional<User> findByEmail(String email);
}
