package _bits.LegalizaMais.domain.budgetItem.dto;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.budgetItem.entity.BudgetItem;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.workService.entity.WorkService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetItemRequestDTO {
    private UUID id;
    private Budget budget;
    private WorkService service;
    private User user;
    private LocalDateTime inclusionDate;
    private boolean inactive;

    public static BudgetItem newBudgetItem(BudgetItemRequestDTO item) {
        return BudgetItem.builder()
                .id(item.getId())
                .budget(item.getBudget())
                .service(item.getService())
                .user(item.getUser())
                .inclusionDate(item.getInclusionDate())
                .inactive(item.isInactive())
                .build();
    }
}