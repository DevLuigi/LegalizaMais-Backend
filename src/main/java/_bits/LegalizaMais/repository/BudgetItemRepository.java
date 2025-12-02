package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.budgetItem.entity.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, UUID> {
}
