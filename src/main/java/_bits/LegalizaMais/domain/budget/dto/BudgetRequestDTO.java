package _bits.LegalizaMais.domain.budget.dto;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.budget.enumBudget.PaymentMethod;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequestDTO {
    private UUID id;
    private String title;
    private String descriptionService;
    private String usedMaterials;
    private int daysOfService;
    private int quantityOfHelpers;
    private BigDecimal dailyRateHelper;
    private BigDecimal total;
    private int discountPercentage;
    private BigDecimal profit;
    private PaymentMethod paymentMethod;
    private String paymentDescription;
    private Client client;
    private User user;
    private LocalDateTime inclusionDate;
    private boolean inactive;

    public static Budget newBudget(BudgetRequestDTO budget) {
        return Budget.builder()
                .id(budget.getId())
                .title(budget.getTitle())
                .descriptionService(budget.getDescriptionService())
                .usedMaterials(budget.getUsedMaterials())
                .daysOfService(budget.getDaysOfService())
                .quantityOfHelpers(budget.getQuantityOfHelpers())
                .dailyRateHelper(budget.getDailyRateHelper())
                .total(budget.getTotal())
                .discountPercentage(budget.getDiscountPercentage())
                .profit(budget.getProfit())
                .paymentMethod(budget.getPaymentMethod())
                .paymentDescription(budget.getPaymentDescription())
                .client(budget.getClient())
                .user(budget.getUser())
                .inclusionDate(budget.getInclusionDate())
                .inactive(budget.isInactive())
                .build();
    }
}
