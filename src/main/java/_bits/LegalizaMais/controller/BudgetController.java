package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.budget.dto.BudgetRequestDTO;
import _bits.LegalizaMais.domain.budget.dto.BudgetResponseDTO;
import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.exception.BudgetException;
import _bits.LegalizaMais.service.BudgetService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    private BudgetService service;

    @GetMapping
    public ResponseEntity<List<BudgetResponseDTO>> listAllBudgets() {
        return ResponseEntity.ok().body(service.listAllBudgets());
    }

    @PostMapping
    public ResponseEntity<BudgetResponseDTO> save(@Valid @RequestBody BudgetRequestDTO data) {
        Optional<Budget> inserted = service.save(data);
        if (inserted.isEmpty()) throw new BudgetException("Não foi possível inserir o orçamento");

        BudgetResponseDTO response = BudgetResponseDTO.fromBudget(inserted.get());
        URI location = URI.create("/budget/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }

    @Transactional
    @DeleteMapping("/{budgetId}")
    public ResponseEntity<Void> deleteBudget(@PathVariable("budgetId") UUID budgetId) {
        boolean deleted = service.deleteById(budgetId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
