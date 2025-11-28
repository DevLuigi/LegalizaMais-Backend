package _bits.LegalizaMais.domain.workService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_service")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class WorkService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_titulo")
    @NotNull(message = "Title must be provided")
    @Size(min = 3, message = "Title must have at least 3 characters")
    private String title;

    @Column(name = "ds_servico")
    @NotNull(message = "Service description must be provided")
    @Size(min = 5, message = "Service description must have at least 5 characters")
    private String serviceDescription;

    @Column(name = "vl_sugestao")
    @NotNull(message = "Suggestion value must be provided")
    private Double suggestedValue;

    // Mandatory fields following the Client pattern
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "dh_alteracao")
    private LocalDateTime changeDate;

    @Column(name = "tg_inativo", nullable = false)
    private Boolean inactive;
}
