package _bits.LegalizaMais.domain.contracts.entity;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.client.entity.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_contracts")
@Entity(name = "ContractEntity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_tipocontrato", nullable = false)
    @NotNull(message = "Tipo de contrato deve ser vinculado ao contrato")
    private TypeContractEntity typeContract;

    @ManyToOne
    @JoinColumn(name = "fk_orcamento", nullable = false)
    @NotNull(message = "Orcamento deve ser vinculado ao contrato")
    private Budget budget;

    @NotNull(message = "Cliente deve ser vinculado ao contrato")
    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Client client;

    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "dh_alteracao")
    private LocalDateTime changeDate;

    @Column(name = "tg_inativo", nullable = false)
    private Boolean inactive;

}
