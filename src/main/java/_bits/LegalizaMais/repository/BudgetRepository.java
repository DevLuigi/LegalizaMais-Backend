package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.budget.dto.BudgetResponseDTO;
import _bits.LegalizaMais.domain.budget.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
    List<Budget> findAllByUser_Id(UUID id);
    boolean existsById(UUID id);
}
