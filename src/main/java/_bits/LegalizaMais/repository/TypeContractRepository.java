package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.domain.contracts.entity.TypeContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeContractRepository extends JpaRepository<TypeContractEntity, UUID> {
    @Query("SELECT t FROM TypeContractEntity t WHERE LOWER(t.nameType) = LOWER(:nameType)")
    TypeContractEntity findIgnoreCase(@Param("nameType") String nameType);

    boolean existsById(UUID id);
}
