package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.budget.dto.BudgetRequestDTO;
import _bits.LegalizaMais.domain.budget.dto.BudgetResponseDTO;
import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.client.dto.ClientRequestDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.dto.UserRequestDTO;
import _bits.LegalizaMais.domain.user.dto.UserResponseDTO;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.exception.BudgetException;
import _bits.LegalizaMais.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository repository;

    public List<BudgetResponseDTO> listAllBudgets() {
        return repository.findAll()
                .stream()
                .map(BudgetResponseDTO::fromBudget)
                .collect(Collectors.toList());
    }

    public Optional<Budget> save(BudgetRequestDTO budget) {
        return Optional.of(repository.save(BudgetRequestDTO.newBudget(budget)));
    }

    public boolean deleteById(UUID budgetId) {
        if (!repository.existsById(budgetId)) throw new BudgetException("Orçamento não encontrado");

        repository.deleteById(budgetId);
        return true;
    }
}
