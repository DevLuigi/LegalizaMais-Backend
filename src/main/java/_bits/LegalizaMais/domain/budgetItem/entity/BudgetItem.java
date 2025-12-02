package _bits.LegalizaMais.domain.budgetItem.entity;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.workService.entity.WorkService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_budgetsitems")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BudgetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne @JoinColumn(name = "fk_orcamento", nullable = false)
    private Budget budget;

    @ManyToOne @JoinColumn(name = "fk_servico", nullable = false)
    private WorkService service;

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