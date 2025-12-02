package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.budgetItem.entity.BudgetItem;
import _bits.LegalizaMais.exception.BudgetItemException;
import _bits.LegalizaMais.repository.BudgetItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BudgetItemService {
    @Autowired
    private BudgetItemRepository repository;

    public Optional<BudgetItem> save(BudgetItem item) {
        return Optional.of(repository.save(item));
    }

    public boolean deleteById(UUID budgetItemId) {
        if (!repository.existsById(budgetItemId)) throw new BudgetItemException("Item do orçamento não encontrado");

        repository.deleteById(budgetItemId);
        return true;
    }
}