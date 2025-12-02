package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
}
