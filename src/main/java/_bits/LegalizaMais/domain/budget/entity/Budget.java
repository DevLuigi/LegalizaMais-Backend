package _bits.LegalizaMais.domain.budget.entity;

import _bits.LegalizaMais.domain.budget.enumBudget.PaymentMethod;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_budgets")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_titulo")
    @NotNull(message = "O título do orçamento deve ser preenchido")
    @Size(min = 5, message = "O título do orçamento deve ter no mínimo 5 caracteres")
    private String title;

    @Column(name = "ds_servico")
    @NotNull(message = "A descrição dos serviços do orçamento deve ser preenchida")
    @Size(min = 15, message = "A descrição dos serviços deve ter no mínimo 15 caracteres")
    private String descriptionService;

    @Column(name = "ds_materiais")
    @NotNull(message = "Os materiais usados devem ser preenchidos")
    @Size(min = 5, message = "Os materiais usados devem ter no mínimo 15 caracteres")
    private String usedMaterials;

    @Column(name = "qt_diasservico")
    @NotNull(message = "A quantidade de dias de serviço deve ser preenchido")
    private int daysOfService;

    @Column(name = "qt_ajudantes")
    @NotNull(message = "A quantidade de ajudantes deve ser preenchida")
    private int quantityOfHelpers;

    @Column(name = "vl_diariaajudante")
    @NotNull(message = "O valor da diaria do ajudante deve ser preenchido")
    private BigDecimal dailyRateHelper;

    @Column(name = "vl_total")
    @NotNull(message = "O valor total deve ser preenchido")
    private BigDecimal total;

    @Column(name = "pr_desconto")
    @NotNull(message = "A porcentagem de desconto deve ser preenchida")
    private int discountPercentage;

    @Column(name = "vl_lucro")
    @NotNull(message = "O valor de lucro deve ser preenchido")
    private BigDecimal profit;

    @Column(name = "tg_formapagamento")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "A forma de pagamento deve ser preenchida")
    private PaymentMethod paymentMethod;

    @Column(name = "ds_formapagamento")
    private String paymentDescription;

    @NotNull(message = "O cliente deve ser preenchido")
    @ManyToOne @JoinColumn(name = "fk_cliente", nullable = false)
    private Client client;

    //Campos obrigatórios
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "dh_alteracao")
    private LocalDateTime changeDate;

    @Column(name = "tg_inativo", nullable = false)
    private Boolean inactive;

    @ManyToOne @JoinColumn(name = "fk_usuario", nullable = false)
    private User user;
}
