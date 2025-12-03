package _bits.LegalizaMais.domain.contracts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_typecontract")
@Entity(name = "TypeContractEntity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class TypeContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Informe o nome do tipo de contrato")
    private String nameType;

    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "dh_alteracao")
    private LocalDateTime changeDate;

    @Column(name = "tg_inativo", nullable = false)
    private Boolean inactive;
}
