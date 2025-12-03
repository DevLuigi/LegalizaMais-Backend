package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.domain.contracts.entity.TypeContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContractRepository  extends JpaRepository<ContractEntity, UUID> {
    Optional<List<ContractEntity>> findByClient(Client client);
    boolean existsByTypeContract(TypeContractEntity typeContract);
    boolean existsByBudget(Budget budget);
    boolean existsByClient(Client client);
}
