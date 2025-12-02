package _bits.LegalizaMais.domain.budgetItem.dto;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.budgetItem.entity.BudgetItem;
import _bits.LegalizaMais.domain.workService.entity.WorkService;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BudgetItemResponseDTO {
    private UUID id;
    private Budget budget;
    private WorkService service;

    public static BudgetItemResponseDTO fromBudgetItem(BudgetItem item) {
        return BudgetItemResponseDTO.builder()
                .id(item.getId())
                .budget(item.getBudget())
                .service(item.getService())
                .build();
    }
}