package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.budgetItem.dto.BudgetItemRequestDTO;
import _bits.LegalizaMais.domain.budgetItem.dto.BudgetItemResponseDTO;
import _bits.LegalizaMais.domain.budgetItem.entity.BudgetItem;
import _bits.LegalizaMais.exception.BudgetItemException;
import _bits.LegalizaMais.service.BudgetItemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("budgetItem")
public class BudgetItemController {
    @Autowired
    private BudgetItemService service;

    @PostMapping
    public ResponseEntity<BudgetItemResponseDTO> save(@Valid @RequestBody BudgetItemRequestDTO data) {
        Optional<BudgetItem> inserted = service.save(BudgetItemRequestDTO.newBudgetItem(data));
        if (inserted.isEmpty()) throw new BudgetItemException("Não foi possível inserir o item do orçamento");

        BudgetItemResponseDTO response = BudgetItemResponseDTO.fromBudgetItem(inserted.get());
        URI location = URI.create("/budgetItem/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }

    @Transactional
    @DeleteMapping("/{budgetItemId}/")
    public ResponseEntity<Void> deleteBudget(@PathVariable("budgetItemId")UUID budgetItemId) {
        boolean deleted = service.deleteById(budgetItemId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
