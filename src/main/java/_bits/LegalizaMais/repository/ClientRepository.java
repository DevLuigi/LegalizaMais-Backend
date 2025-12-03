package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findAllByOrderByNameAsc();

    boolean existsByEmail(String email);

    boolean existsByDocument(String document);

    Optional<Client> findByEmail(String email);
    boolean existsById(UUID id);
}
